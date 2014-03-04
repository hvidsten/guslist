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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextArea;
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
	
	public void makePostData() {
		
		RootPanel rootPanel = RootPanel.get();
		rootPanel.clear();
		makeMenuBar(rootPanel);
		
		HorizontalPanel topleft = new HorizontalPanel();
		rootPanel.add(topleft, 10, 70);
		
		makeSideBar(topleft);
		VerticalPanel datalistPanel = new VerticalPanel();
		topleft.add(datalistPanel);
		
		FlowPanel flowPanel = new FlowPanel();
		datalistPanel.add(flowPanel);
		
		Label progTitlebar = new Label("Post an Ad:");		
		progTitlebar.addStyleName("appTitleBar");
		progTitlebar.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);	
		flowPanel.add(progTitlebar);
		
		HorizontalPanel titlePanel = new HorizontalPanel();
		flowPanel.add(titlePanel);
		
		
		HorizontalPanel namePanel = new HorizontalPanel();
		flowPanel.add(namePanel);

		
		HorizontalPanel titleOfPost = new HorizontalPanel();
		flowPanel.add(titleOfPost);
		
		HorizontalPanel pricePanel = new HorizontalPanel();
		flowPanel.add(pricePanel);
		
		HorizontalPanel descriptionPanel = new HorizontalPanel();
		flowPanel.add(descriptionPanel);
		
		
		Label name = new Label("Name: ");
		final TextBox nameField = new TextBox();
		namePanel.add(name);
		namePanel.add(nameField);
		
		Label Title = new Label("Title: ");
		final TextBox titleField = new TextBox();
		titleOfPost.add(Title);
		titleOfPost.add(titleField);
		
		Label price = new Label("price: ");
		final TextBox priceField = new TextBox();
		pricePanel.add(price);
		pricePanel.add(priceField);
		
		
		final Label description = new Label("description: ");
		flowPanel.add(description);
		TextArea descriptionArea = new TextArea();
		flowPanel.add(descriptionArea);
		
		Button submitButton = new Button("submit");
		submitButton.addStyleName("postInfoButton");
		submitButton.setText("submit");
		flowPanel.add(submitButton);
		
		//final PostData post = new PostData();
		
		submitButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				System.out.println("Submitting data to the server.");
				control.postAdDataToServer(new PostData(titleField.getText(), description.getText(), Double.parseDouble(priceField.getText()), new Seller(nameField.getText())));
				control.viewAdDataFromServer();
			}
		});
		
		
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
		postAdButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				System.out.println("You just got clicked noob!");
				makePostData();
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
