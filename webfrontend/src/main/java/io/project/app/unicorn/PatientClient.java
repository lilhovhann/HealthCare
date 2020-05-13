package io.project.app.unicorn;


import io.project.app.api.requests.LoginRequest;
import io.project.app.dto.AccountDTO;
import io.project.app.dto.PatientDTO;
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
public class PatientClient implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(PatientClient.class);
    /// private final String BASE_URL = getBundle().getString("gateway");

    public PatientClient() {

    }

    @PostConstruct
    public void init() {
        LOG.debug("PatientClient called");
    }

    @SuppressWarnings("unchecked")
    public PatientDTO Registration(PatientDTO model) {
        LOG.info("Start!!!!");
        PatientDTO returnedModel = new PatientDTO();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            LOG.info("PatientDTO Registration ");
            HttpPost request = new HttpPost("http://localhost:5550/api/v2/join/creation");

            String toJson = GsonConverter.toJson(model);
            StringEntity params = new StringEntity(toJson, "UTF-8");
            request.addHeader("content-type", "application/json;charset=UTF-8");
            request.addHeader("charset", "UTF-8");
            request.setEntity(params);
            long startTime = System.currentTimeMillis();
            try (CloseableHttpResponse httpResponse = httpClient.execute(request)) {
                LOG.info("User Registration status code " + httpResponse.getStatusLine().getStatusCode());
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    returnedModel = GsonConverter.fromJson(EntityUtils.toString(httpResponse.getEntity()), PatientDTO.class);
                }
            }
            long elapsedTime = System.currentTimeMillis() - startTime;
            LOG.info("User Registration request/response time in milliseconds: " + elapsedTime);
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
