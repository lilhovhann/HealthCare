package io.project.app.beans.auth;

import java.io.Serializable;
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

        MindmapNode status = new DefaultMindmapNode("Status", "", "5DA493", true);
        MindmapNode id = new DefaultMindmapNode("ID", "", "A6E7FF", true);
        MindmapNode Name = new DefaultMindmapNode("Name", "", "FF8866", true);
        MindmapNode Contacts = new DefaultMindmapNode("Contacts", "", "50BFE6", true);
        MindmapNode Gender = new DefaultMindmapNode("Gender", "", "FF6037", true);
        MindmapNode Birthdate = new DefaultMindmapNode("Birthdate", "", "6e9ebf", true);
        MindmapNode DeseasedStatus = new DefaultMindmapNode("Desease Status", "", "BFAFB2", true);
        MindmapNode Address = new DefaultMindmapNode("Address", "", "FF878D", true);
        MindmapNode ContactParty = new DefaultMindmapNode("Contact Party", "", "FFCFF1", true);
        MindmapNode Language = new DefaultMindmapNode("Language", "", "AF6E4D", true);
        MindmapNode Consent = new DefaultMindmapNode("Consent", "", "d581de", true);
        MindmapNode Practitioner = new DefaultMindmapNode("Practitioner", "", "6EAEA1", true);

        root.addNode(Consent);
        root.addNode(status);
        root.addNode(Name);
        root.addNode(Contacts);
        root.addNode(Gender);
        root.addNode(Birthdate);
        root.addNode(DeseasedStatus);
        root.addNode(Address);
        root.addNode(id);
        root.addNode(ContactParty);
        root.addNode(Language);

        root.addNode(Practitioner);

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

            if (label.equals("Name")) {
                node.addNode(new DefaultMindmapNode("Use", "use", "82c542", true));
                node.addNode(new DefaultMindmapNode("Name", "text", "82c542", true));
                node.addNode(new DefaultMindmapNode("Surname", "family", "82c542", true));
            } 
            else if (label.equals("status")) {
                node.addNode(new DefaultMindmapNode("Active", "", "82c542", true));
                node.addNode(new DefaultMindmapNode("Passive", "", "82c542", true));
               
            } else if (label.equals("Gender")) {
                node.addNode(new DefaultMindmapNode("Male", "male", "82c542", true));
                node.addNode(new DefaultMindmapNode("Female", "female", "82c542", true));
                node.addNode(new DefaultMindmapNode("Other", "other", "82c542", true));
                node.addNode(new DefaultMindmapNode("Unknown", "unknown", "82c542", true));
            } else if (label.equals("Address")) {
                node.addNode(new DefaultMindmapNode("Country", "country", "82c542", true));
                node.addNode(new DefaultMindmapNode("City", "city", "82c542", true));
                node.addNode(new DefaultMindmapNode("Address box", "address box", "82c542", true));
                node.addNode(new DefaultMindmapNode("Postal code", "postal code", "82c542", true));
            } else if (label.equals("ContactParty")) {
                node.addNode(new DefaultMindmapNode("Name", "name", "82c542", true));
                node.addNode(new DefaultMindmapNode("Gender", "gender", "82c542", true));
                node.addNode(new DefaultMindmapNode("Address", "address", "82c542", true));
                node.addNode(new DefaultMindmapNode("Relationship with patient", "relationship with patient", "82c542", true));
            } else if (label.equals("Language")) {
                node.addNode(new DefaultMindmapNode("Armenian", "armenian", "82c542", true));
                node.addNode(new DefaultMindmapNode("Russian", "russian", "82c542", true));
                node.addNode(new DefaultMindmapNode("English", "english", "82c542", true));
            } else if (label.equals("Contacts")) {
                node.addNode(new DefaultMindmapNode("Phone", "phone", "82c542", true));
                node.addNode(new DefaultMindmapNode("Email", "email", "82c542", true));
                node.addNode(new DefaultMindmapNode("Viber", "viber", "82c542", true));
            } else if (label.equals("DeseasedStatus")) {
                node.addNode(new DefaultMindmapNode("Desease Date", "date", "82c542", true));
            } else if (label.equals("Consent")) {
                node.addNode(new DefaultMindmapNode("Status", "status", "82c542", true));
                node.addNode(new DefaultMindmapNode("Provision type", "provision type", "82c542", true));
                node.addNode(new DefaultMindmapNode("Period", "period", "82c542", true));
            } else if (label.equals("Practitioner")) {
                node.addNode(new DefaultMindmapNode("Name", "name", "82c542", true));
                node.addNode(new DefaultMindmapNode("Surname", "surname", "82c542", true));
                node.addNode(new DefaultMindmapNode("Role", "role", "82c542", true));

            }

        }
    }

    public void onNodeDblselect(SelectEvent<MindmapNode> event) {
        this.selectedNode = event.getObject();
    }
}
