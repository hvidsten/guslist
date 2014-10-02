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
		
		VerticalPanel dataListPanel = new VerticalPanel();
		horizontalPanel.add(dataListPanel);
		
		makeSideBar(horizontalPanel);
		
		FlowPanel flowPanel = new FlowPanel();
		dataListPanel.add(flowPanel);
		
		Label progTitlebar = new Label("GusList");
		progTitlebar.addStyleName("appTitleBar");
		progTitlebar.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		//flowPanel.add(progTitlebar);
		horizontalPanel.add(progTitlebar);
		
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
						viewMakeNewAdPage();
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
	
	public void viewMakeNewAdPage(){
		RootPanel rootPanel = RootPanel.get();
		rootPanel.clear();
		makeMenuBar(rootPanel);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rootPanel.add(horizontalPanel, 10, 79);
		horizontalPanel.setSize("412px", "211px");
		
		VerticalPanel dataListPanel = new VerticalPanel();
		horizontalPanel.add(dataListPanel);
		
		makeSideBar(horizontalPanel);
		
		FlowPanel flowPanel = new FlowPanel();
		dataListPanel.add(flowPanel);
		
		Label progTitlebar = new Label("GusList");
		progTitlebar.addStyleName("appTitleBar");
		progTitlebar.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		//flowPanel.add(progTitlebar);
		horizontalPanel.add(progTitlebar);
		
		HorizontalPanel horizontalPanel2 = new HorizontalPanel();
		rootPanel.add(horizontalPanel2, 100, 200);
		VerticalPanel labels = enterPostInfo();
		//labels.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel2.add(labels);
		VerticalPanel entry = textInput();
		horizontalPanel2.add(entry);
		
		
		
	}
	
	public VerticalPanel enterPostInfo() {
		VerticalPanel column = new VerticalPanel();
		Label titleLabel = new Label("Title");
		titleLabel.addStyleName("postLabel");
		Label descrLabel = new Label("Description");
		descrLabel.addStyleName("postLabel");
		Label priceLabel = new Label("Price");
		priceLabel.addStyleName("postLabel");
		Label sellerLabel = new Label("Your Name");
		priceLabel.addStyleName("postLabel");
		column.add(titleLabel);
		column.add(descrLabel);
		column.add(priceLabel);
		column.add(sellerLabel);
		
		return column;
	}
	
	private VerticalPanel textInput() {
		VerticalPanel column = new VerticalPanel();
		final TextBox titleInput = new TextBox();
		final TextArea descrInput = new TextArea();
		final TextBox priceInput = new TextBox();
		final TextBox sellerInput = new TextBox();
		
		column.add(titleInput);
		column.add(descrInput);
		column.add(priceInput);
		column.add(sellerInput);
		
		Button infoButton = new Button("Submit");
		infoButton.addStyleName("postInfoButton");
		infoButton.setText("Submit");
		//add a clickListener to the button
		infoButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PostData newEntry = new PostData(titleInput.getText(), descrInput.getText(),Double.parseDouble(priceInput.getText()),new Seller(sellerInput.getText()));
				control.MakePostAdDataToServer(newEntry);
			}
	      });
		column.add(infoButton);
		return column;
	}
	
}