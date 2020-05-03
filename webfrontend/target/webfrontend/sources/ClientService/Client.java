package ClientService;

import io.project.app.patientcare.models.Account;
import io.project.app.api.requests.LoginRequest;
import io.project.app.util.GsonConverter;
import java.io.IOException;
import java.io.Serializable;
import java.util.PropertyResourceBundle;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

@Named
@SessionScoped
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(Client.class);
    private final String BASE_URL = getBundle().getString("gateway");

    public Client() {

    }

    @PostConstruct
    public void init() {
        LOG.debug("UserAuthClient called");
    }

    public Account getUserByPhone(String phone) {
        LOG.info("Find account by phone " + phone);
        Account model = new Account();
        long startTime = System.currentTimeMillis();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(BASE_URL + "/register/api/v2/accounts/find/account/phone?phone=" + phone);
            request.addHeader("charset", "UTF-8");
            CloseableHttpResponse response = httpClient.execute(request);
            response.addHeader("content-type", "application/json;charset=UTF-8");
            try (CloseableHttpResponse httpResponse = httpClient.execute(request)) {
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    model = GsonConverter.fromJson(EntityUtils.toString(httpResponse.getEntity()), Account.class);
                }
            }
            long elapsedTime = System.currentTimeMillis() - startTime;
            LOG.info("Find account by phone request/response time in milliseconds: " + elapsedTime);
        } catch (IOException e) {
            LOG.error("Exception caught.", e);
        }
        return model;
    }

//    public Account getUserById(String userId) {
//        LOG.info("Find user by id " + userId);
//        User model = new User();
//        long startTime = System.currentTimeMillis();
//        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            HttpGet request = new HttpGet(BASE_URL + "/register/api/v2/users/find/user/id?userId=" + userId);
//            request.addHeader("charset", "UTF-8");
//            CloseableHttpResponse response = httpClient.execute(request);
//            response.addHeader("content-type", "application/json;charset=UTF-8");
//            try (CloseableHttpResponse httpResponse = httpClient.execute(request)) {
//                if (httpResponse.getStatusLine().getStatusCode() == 200) {
//                    model = GsonConverter.fromJson(EntityUtils.toString(httpResponse.getEntity()), User.class);
//                }
//            }
//            long elapsedTime = System.currentTimeMillis() - startTime;
//            LOG.info("Find user by id request/response time in milliseconds: " + elapsedTime);
//        } catch (IOException e) {
//            LOG.error("Exception caught.", e);
//        }
//        return model;
//    }

    @SuppressWarnings("unchecked")
    public Account accountLogin(LoginRequest model) {
        LOG.info("Account login: called ");
        Account returnedModel = new Account();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(BASE_URL + "/auth/api/v2/accounts/auth");
            String toJson = GsonConverter.toJson(model);
            StringEntity params = new StringEntity(toJson, "UTF-8");
            request.addHeader("content-type", "application/json");
            request.addHeader("charset", "UTF-8");
            request.setEntity(params);
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            long startTime = System.currentTimeMillis();
            try (CloseableHttpResponse httpResponse = httpClient.execute(request)) {
                LOG.info("Account login: httpResponse.getStatusLine().getStatusCode() " + httpResponse.getStatusLine().getStatusCode());
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    returnedModel = GsonConverter.fromJson(EntityUtils.toString(httpResponse.getEntity()), Account.class);
                }
            }
            long elapsedTime = System.currentTimeMillis() - startTime;
            LOG.info("Account login: request/response time in milliseconds: " + elapsedTime);

        } catch (IOException e) {
            LOG.error("Exception caught.", e);
        }
        return returnedModel;
    }

    @SuppressWarnings("unchecked")
    public Account account(Account model) {
        Account returnedModel = new Account();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            LOG.info("Account Registration ");
            HttpPost request = new HttpPost(BASE_URL + "/register/api/v2/accounts/register");

            String toJson = GsonConverter.toJson(model);
            StringEntity params = new StringEntity(toJson, "UTF-8");
            request.addHeader("content-type", "application/json;charset=UTF-8");
            request.addHeader("charset", "UTF-8");
            request.setEntity(params);
            long startTime = System.currentTimeMillis();
            try (CloseableHttpResponse httpResponse = httpClient.execute(request)) {
                LOG.info("Account Registration status code " + httpResponse.getStatusLine().getStatusCode());
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    returnedModel = GsonConverter.fromJson(EntityUtils.toString(httpResponse.getEntity()), Account.class);
                }
            }
            long elapsedTime = System.currentTimeMillis() - startTime;
            LOG.info("Account Registration request/response time in milliseconds: " + elapsedTime);
        } catch (IOException e) {
            LOG.error("Exception caught.", e);
        }
        return returnedModel;
    }


    public PropertyResourceBundle getBundle() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication().evaluateExpressionGet(context, "#{i18n}", PropertyResourceBundle.class);
    }
}

// http://aspects.jcabi.com/annotation-cacheable.html
// http://aspects.jcabi.com/example-weaving.html
