package com.aidilab.airbus.gridview;

public class GridObject{
	 
	 String title;
	 String description;
	 int imageResource;
	 
	 public GridObject(){}
	 
	 public GridObject(String title, String description, int imageResource){
		 this.title = title;
		 this.description = description;
		 this.imageResource = imageResource;
	 }

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the imageResource
	 */
	public int getImageResource() {
		return imageResource;
	}

	/**
	 * @param imageResource the imageResource to set
	 */
	public void setImageResource(int imageResource) {
		this.imageResource = imageResource;
	}
	 
	 
	 
}
