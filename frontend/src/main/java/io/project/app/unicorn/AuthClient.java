package io.project.app.unicorn;


import io.project.app.api.requests.LoginRequest;

import io.project.app.models.Account;
import io.project.app.util.GsonConverter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class AuthClient implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(AuthClient.class);
    /// private final String BASE_URL = getBundle().getString("gateway");

    public AuthClient() {

    }

    @PostConstruct
    public void init() {
        LOG.debug("UserAuthClient called");
    }

    @SuppressWarnings("unchecked")
    public Account userRegistration(Account model) {
        LOG.info("Start!!!!");
        Account returnedModel = new Account();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            LOG.info("User Registration ");
            HttpPost request = new HttpPost("http://localhost:5550/api/v2/join/registration");

            String toJson = GsonConverter.toJson(model);
            StringEntity params = new StringEntity(toJson, "UTF-8");
            request.addHeader("content-type", "application/json;charset=UTF-8");
            request.addHeader("charset", "UTF-8");
            request.setEntity(params);
            long startTime = System.currentTimeMillis();
            try (CloseableHttpResponse httpResponse = httpClient.execute(request)) {
                LOG.info("User Registration status code " + httpResponse.getStatusLine().getStatusCode());
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    returnedModel = GsonConverter.fromJson(EntityUtils.toString(httpResponse.getEntity()), Account.class);
                }
            }
            long elapsedTime = System.currentTimeMillis() - startTime;
            LOG.info("User Registration request/response time in milliseconds: " + elapsedTime);
        } catch (IOException e) {
            LOG.error("Exception caught.", e);
        }
        return returnedModel;
    }

    @SuppressWarnings("unchecked")
    public Account userLogin(LoginRequest model) {
        LOG.info("User login: called ");
        Account returnedModel = new Account();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost request = new HttpPost("http://localhost:5550/api/v2/join/login");
            String toJson = GsonConverter.toJson(model);
            StringEntity params = new StringEntity(toJson, "UTF-8");
            request.addHeader("content-type", "application/json");
            request.addHeader("charset", "UTF-8");
            request.setEntity(params);
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            long startTime = System.currentTimeMillis();
            try (CloseableHttpResponse httpResponse = httpClient.execute(request)) {
                LOG.info("User login: httpResponse.getStatusLine().getStatusCode() " + httpResponse.getStatusLine().getStatusCode());
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    returnedModel = GsonConverter.fromJson(EntityUtils.toString(httpResponse.getEntity()), Account.class);
                }
            }
            long elapsedTime = System.currentTimeMillis() - startTime;
            LOG.info("User login: request/response time in milliseconds: " + elapsedTime);

        } catch (IOException e) {
            LOG.error("Exception caught.", e);
        }
        return returnedModel;
    }
    
    

    public List<Account> getUserByAccountType(String accountType) {
        LOG.info("Find user by accountType " + accountType);
//        AccountDTO model = new AccountDTO();
        List<Account> newmodel =  new ArrayList<Account>();;
        long startTime = System.currentTimeMillis();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("http://localhost:5550/api/v2/join/find/type" + accountType);
            request.addHeader("charset", "UTF-8");
            CloseableHttpResponse response = httpClient.execute(request);
            response.addHeader("content-type", "application/json;charset=UTF-8");
            try (CloseableHttpResponse httpResponse = httpClient.execute(request)) {
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    newmodel = GsonConverter.fromJson(EntityUtils.toString(httpResponse.getEntity()), List.class);
                    LOG.info("response is "+httpResponse.getEntity());
                }
            }
            long elapsedTime = System.currentTimeMillis() - startTime;
            LOG.info("Find user by account type request/response time in milliseconds: " + elapsedTime);
        } catch (IOException e) {
            LOG.error("Exception caught.", e);
        }
        LOG.info("the list of accounts are "+ newmodel);
        
       return newmodel;
    }

//    public User getUserById(String userId) {
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

    public PropertyResourceBundle getBundle() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication().evaluateExpressionGet(context, "#{i18n}", PropertyResourceBundle.class);
    }
}

// http://aspects.jcabi.com/annotation-cacheable.html
// http://aspects.jcabi.com/example-weaving.html
