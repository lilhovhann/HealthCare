package io.project.app.beans.auth;

import java.io.Serializable;
import java.util.UUID;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.mindmap.DefaultMindmapNode;
import org.primefaces.model.mindmap.MindmapNode;

@Named
@RequestScoped
public class MindViewBean implements Serializable {

    private MindmapNode root;

    private MindmapNode selectedNode;

    public MindViewBean() {
        root = new DefaultMindmapNode("PATIENT", "fhir model", "FFCC00", false);

//        MindmapNode ids = new DefaultMindmapNode("ids", "id of patient", "6e9ebf", true);
        MindmapNode active = new DefaultMindmapNode("active", "status of patient", "6e9ebf", true);
        MindmapNode name = new DefaultMindmapNode("name", "name details of patient", "6e9ebf", true);
        MindmapNode contact = new DefaultMindmapNode("contact", "IP ids", "6e9ebf", true);
        MindmapNode gender = new DefaultMindmapNode("gender", "IP ids", "6e9ebf", true);
        MindmapNode birthdate = new DefaultMindmapNode("birthdate", "IP ids", "6e9ebf", true);
        MindmapNode deseaseBoolean = new DefaultMindmapNode("deseaseBoolean", "IP ids", "6e9ebf", true);
        MindmapNode address = new DefaultMindmapNode("address", "IP ids", "6e9ebf", true);
        MindmapNode attachment = new DefaultMindmapNode("attachment", "IP ids", "6e9ebf", true);
        MindmapNode contactParty = new DefaultMindmapNode("contactParty", "IP ids", "6e9ebf", true);
        MindmapNode language = new DefaultMindmapNode("language", "IP ids", "6e9ebf", true);
        MindmapNode consent = new DefaultMindmapNode("consent", "IP ids", "d581de", true);
        MindmapNode practitioner = new DefaultMindmapNode("practitioner", "IP ids", "6e9ebf", true);

        root.addNode(consent);
//        root.addNode(ids);
        root.addNode(active);
        root.addNode(name);
        root.addNode(contact);
        root.addNode(gender);
        root.addNode(birthdate);
        root.addNode(deseaseBoolean);
        root.addNode(address);
        root.addNode(attachment);
        root.addNode(contactParty);
        root.addNode(language);

        root.addNode(practitioner);

    }

    public MindmapNode getRoot() {
        return root;
    }

    public MindmapNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(MindmapNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public void onNodeSelect(SelectEvent<MindmapNode> event) {
        MindmapNode node = event.getObject();

        if (node.getChildren().isEmpty()) {
            Object label = node.getLabel();

            if (label.equals("name")) {
                node.addNode(new DefaultMindmapNode("use", "use", "82c542", true));
                node.addNode(new DefaultMindmapNode("text", "text", "82c542", true));
                node.addNode(new DefaultMindmapNode("family", "family", "82c542", true));

            } else if (label.equals("gender")) {
                node.addNode(new DefaultMindmapNode("male", "male", "82c542", true));
                node.addNode(new DefaultMindmapNode("female", "female", "82c542", true));
                node.addNode(new DefaultMindmapNode("other", "other", "82c542", true));
                node.addNode(new DefaultMindmapNode("unknown", "unknown", "82c542", true));
            } else if (label.equals("address")) {
                node.addNode(new DefaultMindmapNode("country", "country", "82c542", true));
                node.addNode(new DefaultMindmapNode("city", "city", "82c542", true));
                node.addNode(new DefaultMindmapNode("address box", "address box", "82c542", true));
                node.addNode(new DefaultMindmapNode("postal code", "postal code", "82c542", true));
            } else if (label.equals("contactParty")) {
                node.addNode(new DefaultMindmapNode("name", "name", "82c542", true));
                node.addNode(new DefaultMindmapNode("gender", "gender", "82c542", true));
                node.addNode(new DefaultMindmapNode("address", "address", "82c542", true));
                node.addNode(new DefaultMindmapNode("relationship with patient", "relationship with patient", "82c542", true));
            } else if (label.equals("language")) {
                node.addNode(new DefaultMindmapNode("armenian", "armenian", "82c542", true));
                node.addNode(new DefaultMindmapNode("russian", "russian", "82c542", true));
                node.addNode(new DefaultMindmapNode("english", "english", "82c542", true));

            } else if (label.equals("contact")) {
                node.addNode(new DefaultMindmapNode("phone", "phone", "82c542", true));
                node.addNode(new DefaultMindmapNode("email", "email", "82c542", true));
                node.addNode(new DefaultMindmapNode("viber", "viber", "82c542", true));

            } else if (label.equals("deseaseBoolean")) {
                node.addNode(new DefaultMindmapNode("desease Date", "date", "82c542", true));

            } else if (label.equals("consent")) {
                node.addNode(new DefaultMindmapNode("status", "status", "82c542", true));
                node.addNode(new DefaultMindmapNode("provision type", "provision type", "82c542", true));
                node.addNode(new DefaultMindmapNode("period", "period", "82c542", true));

            } else if (label.equals("practitioner")) {
                node.addNode(new DefaultMindmapNode("name", "name", "82c542", true));
                node.addNode(new DefaultMindmapNode("surname", "surname", "82c542", true));
                node.addNode(new DefaultMindmapNode("role", "role", "82c542", true));

            }

        }
    }

    public void onNodeDblselect(SelectEvent<MindmapNode> event) {
        this.selectedNode = event.getObject();
    }
}
