/*
 * View class for GusList app.
 * Handles all GUI components and event callback mechanisms 
 */

package edu.gac.mcs270.hvidsten.guslist.client;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.gac.mcs270.hvidsten.guslist.shared.Buyer;
import edu.gac.mcs270.hvidsten.guslist.shared.PostData;
import edu.gac.mcs270.hvidsten.guslist.shared.Seller;

public class GusListView {
	private GusList control;

	public GusListView(){}
	
	public void setController(GusList gusList) {
		control = gusList;
	}

	public GusList getController() {
		return control;
	}
	
	public void viewWelcomePage(){
		RootPanel rootPanel = RootPanel.get();
		rootPanel.clear();
		makeMenuBar(rootPanel);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rootPanel.add(horizontalPanel, 10, 79);
		horizontalPanel.setSize("412px", "211px");
		
		makeSideBar(horizontalPanel);
	}
	
	public void viewPostAd() {
		
		RootPanel rootPanel = RootPanel.get();
		rootPanel.clear();
		makeMenuBar(rootPanel);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rootPanel.add(horizontalPanel, 10, 79);
		
		makeSideBar(horizontalPanel);
		
		VerticalPanel dataListPanel = new VerticalPanel();
		horizontalPanel.add(dataListPanel);
		
		FlowPanel flowPanel1 = new FlowPanel();
		dataListPanel.add(flowPanel1);
		
		HorizontalPanel horizontalPane2 = new HorizontalPanel();
		flowPanel1.add(horizontalPane2);
		final TextBox box1 = new TextBox();
		Label label= new Label("Poster Name:");
		horizontalPane2.add(label);
		flowPanel1.add(box1);
		
		HorizontalPanel horizontalPane3 = new HorizontalPanel();
		flowPanel1.add(horizontalPane3);
		final TextBox box2 = new TextBox();
		Label labe2= new Label("Title of Post:");
		horizontalPane3.add(labe2);
		flowPanel1.add(box2);
		
		HorizontalPanel horizontalPane4 = new HorizontalPanel();
		flowPanel1.add(horizontalPane4);
		final TextBox box3 = new TextBox();
		Label labe3= new Label("Price:");
		horizontalPane4.add(labe3);
		flowPanel1.add(box3);
		
		final TextArea textArea1= new TextArea();
		Label labe4= new Label("Discription:");
		HorizontalPanel horizontalPane5 = new HorizontalPanel();
		flowPanel1.add(horizontalPane5);
		horizontalPane5.add(labe4);
		flowPanel1.add(textArea1);
		
		
		
		Button subBut= new Button("Submit");
		subBut.addStyleName("submitButton");
		subBut.setText("Submit");
		subBut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				control.postAdDataToServer(new PostData(box1.getText(),textArea1.getText(),Double.parseDouble(box3.getText()), new Seller(box2.getText()),new Buyer("Bill")));
				control.viewAdDataFromServer();
			}
			});
		flowPanel1.add(subBut);
		
		}	
		
	public void viewPostData(List<PostData> posts) {
		if(posts==null) return;
		
		RootPanel rootPanel = RootPanel.get();
		rootPanel.clear();
		makeMenuBar(rootPanel);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rootPanel.add(horizontalPanel, 10, 79);
		
		makeSideBar(horizontalPanel);
		
		VerticalPanel dataListPanel = new VerticalPanel();
		horizontalPanel.add(dataListPanel);
		
		FlowPanel flowPanel = new FlowPanel();
		dataListPanel.add(flowPanel);
		
		Label progTitlebar = new Label("GusList");
		progTitlebar.addStyleName("appTitleBar");
		progTitlebar.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(progTitlebar);
		
		makePostTable(posts, flowPanel);
	}
	
	private void makePostTable(List<PostData> posts, FlowPanel flowPanel) {
		for(PostData post: posts){
			flowPanel.add(makePostRow(post));
		}
	}

	private HorizontalPanel makePostRow(PostData post) {
		HorizontalPanel row = new HorizontalPanel();
		Label titleLabel = new Label(post.getTitle());
		titleLabel.addStyleName("postLabel");
		Label descrLabel = new Label(post.getDescription());
		descrLabel.addStyleName("postLabel");
		Label priceLabel = new Label("$"+post.getPrice());
		priceLabel.addStyleName("postLabel");
		Button infoButton = new Button("More Info");
		infoButton.addStyleName("postInfoButton");
		infoButton.setText("More Info");
		//add a clickListener to the button
		infoButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// To Do
			}
	      });
		row.add(titleLabel);
		row.add(descrLabel);
		row.add(priceLabel);
		row.add(infoButton);
		return row;
	}

	public void makeMenuBar(RootPanel rp){
		MenuBar menuBar = new MenuBar(false);
		rp.add(menuBar, 94, 39);
		menuBar.setSize("326px", "32px");
		
		MenuItem menuHomeItem = new MenuItem("Home", false, new Command() {
			public void execute() {
				viewWelcomePage();
			}
		});
		menuHomeItem.setHTML("Home");
		menuBar.addItem(menuHomeItem);
		
		MenuItemSeparator separator = new MenuItemSeparator();
		menuBar.addSeparator(separator);
		
		MenuItem menuSignInItem = new MenuItem("Sign In", false, (Command) null);
		menuSignInItem.setHTML("Sign In");
		menuBar.addItem(menuSignInItem);
		
		MenuItem menuContactItem = new MenuItem("Contact", false, (Command) null);
		menuContactItem.setHTML("Contact");
		menuBar.addItem(menuContactItem);
		
		MenuItem menuHelpItem = new MenuItem("Help", false, (Command) null);
		menuHelpItem.setHTML("Help");
		menuBar.addItem(menuHelpItem);
	}
	
	public void makeSideBar(HorizontalPanel hp){
		VerticalPanel sidePanel = new VerticalPanel();
		hp.add(sidePanel);
		sidePanel.setSize("72px", "98px");
		
		Button postAdButton = new Button("Post Ad");
		postAdButton.setStyleName("sideBarButton");
		postAdButton.setText("Post Ad");
		//add a clickListener to the button
		postAdButton.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						viewPostAd();
					}
			      });

		sidePanel.add(postAdButton);
		
		
		Button viewAdsButton = new Button("View Ads");
		viewAdsButton.setStyleName("sideBarButton");
		viewAdsButton.setText("View Ads");
		//add a clickListener to the button
		viewAdsButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				control.viewAdDataFromServer();
			}
	      });
		sidePanel.add(viewAdsButton);
		
		Hyperlink adminHyperlink = new Hyperlink("Admin Page", false, "newHistoryToken");
		sidePanel.add(adminHyperlink);
		
	}
}
