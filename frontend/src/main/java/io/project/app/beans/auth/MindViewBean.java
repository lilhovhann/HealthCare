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
         
        MindmapNode ids = new DefaultMindmapNode("ids", "IP ids", "6e9ebf", true);
        MindmapNode active = new DefaultMindmapNode("active", "active", "6e9ebf", true);
        MindmapNode name = new DefaultMindmapNode("name", "Malicious Software", "6e9ebf", true);
        MindmapNode contact = new DefaultMindmapNode("contact", "IP ids", "6e9ebf", true);
        MindmapNode gender = new DefaultMindmapNode("gender", "IP ids", "6e9ebf", true);
        MindmapNode birthdate = new DefaultMindmapNode("birthdate", "IP ids", "6e9ebf", true);
        MindmapNode deseaseBoolean = new DefaultMindmapNode("deseaseBoolean", "IP ids", "6e9ebf", true);
        MindmapNode address = new DefaultMindmapNode("address", "IP ids", "6e9ebf", true);
        MindmapNode attachment = new DefaultMindmapNode("attachment", "IP ids", "6e9ebf", true);
        MindmapNode contactParty = new DefaultMindmapNode("contactParty", "IP ids", "6e9ebf", true);
        MindmapNode language = new DefaultMindmapNode("language", "IP ids", "6e9ebf", true);
        MindmapNode practitioner = new DefaultMindmapNode("practitioner", "IP ids", "6e9ebf", true);
         
        root.addNode(ids);
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
         
        //populate if not already loaded
        if(node.getChildren().isEmpty()) {
            Object label = node.getLabel();
 
            if(label.equals("GOOGLE")) {
               
            
                    node.addNode(new DefaultMindmapNode("GOOGLE: ", "THE BEST SEARCH ENGINE", "82c542", true));// ete trua, apa double click karas anes
                    
               
            }
            else if(label.equals("IPs")) {
               // for(int i = 0; i < 18; i++) {
                    //node.addNode(new DefaultMindmapNode("1.1.1."  + i, "IP Number: 1.1.1." + i, "fce24f", false));
               // } 
            }
            else if(label.equals("Malware")) {
                for(int i = 0; i < 18; i++) {
                    String random = UUID.randomUUID().toString();
                    node.addNode(new DefaultMindmapNode("Malware-"  + random, "Malicious Software: " + random, "3399ff", false));
                }
            }
        }   
    }
     
    public void onNodeDblselect(SelectEvent<MindmapNode> event) {
        this.selectedNode = event.getObject();
    }
}
