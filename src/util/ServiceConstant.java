package util;

public class ServiceConstant {

	//Product related
	public static String PRODUCT_ENTITY = "productEntity";
	public static String P_ID = "p_ID";
	public static String P_NAME = "p_Name";
	public static String P_IMAGE_URL = "p_ImageURL";
	public static String P_BRAND = "brand";
	public static String P_CATEGORY = "category";
	public static String P_DESCRIPTION = "description";
	public static String ORIGINAL_PRICE =  "originalPrice";
	public static String DISCOUNT_PRICE =  "discountPrice";
	public static String IS_VEG = "isVeg";
	public static String PRODUCT_WEIGHT = "producWeight";
	public static String DISCOUNT_PERCENTAGE = "discountPercentage";
	public static String SUB_CATEGORY_ID = "subCategoryId";
	public static String NUTRITIONAL_VALUE = "nutritionalValue";
	public static String P_SOLD_NUMBER = "soldQuantity";
	public static String P_TYPE = "pType";
	
	//Category related
	public static String CATEGORY_ENTITY = "categoryEntity";
	public static String CATEGORY_ID = "c_ID";
	public static String CATEGORY_NAME = "c_Name";
	public static String C_IMAGE_URL = "c_ImageURL";
	public static String C_PARENT_ID = "c_ParentId";
	
	public enum Type {
		discounted,
		populer
	}
			
}
