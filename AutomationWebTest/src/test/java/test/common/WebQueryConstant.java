package test.common;

public class WebQueryConstant {
	
	// Information of Rim
	public static final int Width = 289;
	public static final int AspectR = 354;
	public static final int RimSize = 283;
	public static final int LoadIndex = 235;
	public static final int SpeedRating = 295;
	public static final int Lifespan = 330;
	public static final int FuelEfficiency = 333;
	public static final int Braking = 331;
	public static final int Comfort = 190;
	public static final int Warranty = 328;
	
	// language code
	public static final String lang = "en";
	
	// text role id
	public static final int DescTxt = 1074;
	public static final int[] BenefitsTxt = new int[] { 1069, 1070, 1071 } ;
	public static final int[] FeaturesTxt = new int[] { 1060, 1061, 1062 } ;
	public static final int[] RtbTxt = new int[] { 1050, 1051, 1052 } ;
	public static final int[] PVClass = new int[] { 982, 983, 994 } ;
	
	// query to count rim size in product detail page
	public static final String queryValueInProDetailPage(Integer marketID, String productID, String sizeOfRim) {
		String valueInProDetailPage = "Select distinct vp.* from Tyre.ProductVariant pv "
				+ "JOIN Tyre.VariantProperty vp on vp.ProductVariantId = pv.ProductVariantId "
				+ "Join Tyre.VariantMarket vm on vm.ProductVariantId = vp.ProductVariantId "
				+ "JOIN Tyre.ProductMasterData ma on ma.ProductId = pv.ProductId "
				+ "where vm.MarketId = "+marketID+" and ma.ProductClassId in ("+PVClass[0]+", "+PVClass[1]+", "+PVClass[2]+") and Detele_Flg = 0 and BrandId = 4 "
				+ "and pv.productID= "+productID+ " and PropertyId in ("+Width+","+AspectR+","+RimSize+","+LoadIndex+","+SpeedRating+","+Lifespan+","+FuelEfficiency+","+Braking+","+Comfort+")"
				+ "and vp.ProductVariantId in (select ProductVariantId from tyre.VariantProperty where propertyid = "+RimSize+""
				+ "and value like '"+sizeOfRim+"%') ";
		return valueInProDetailPage;
	}
	
	public static final String queryGetURLProductImage(String prodID){
		String getURLProdImg = "select * from [Tyre].[Asset] "
				+ "join tyre.AssetValue on Asset.AssetId = AssetValue.AssetId "
				+ "where ProductId = " + prodID
				+ " and CollectionId = 1004 and Character = '1'";
		return getURLProdImg;
	}
	
	public static final String queryGetUrlFABImage(String prodID){
		String getUrlFABImg = "Select DISTINCT av.* from Tyre.Asset at "
				+"JOIN Tyre.AssetValue av on av.AssetId = at.AssetId "
				+"where at.ProductId = "+prodID+"and at.CollectionId =1075 and av.Character = 'B'";
		return getUrlFABImg;
	}
	
	public static final String queryCountNoOfProd(Integer marketId){ 
		String countNoOfProd = "select count(*)AS RESULT from "
			+ "(select DISTINCT MasterName from Tyre.ProductMasterData pm "
			+ "JOIN Tyre.ProductVariant pv on pm.ProductId = pv.ProductId "
			+ "JOIN Tyre.VariantMarket vm on vm.ProductVariantId = pv.ProductVariantId "
			+ "WHERE vm.MarketId = "+marketId+" and ProductClassId in ("+PVClass[0]+", "+PVClass[1]+", "+PVClass[2]+") "
			+ "AND BrandId = 4 and pm.Detele_Flg = 0) myNewTable";
		return countNoOfProd;
	}
	
	public static final String queryGetProdText(String prodID){ 
		String getProdTxt = "select * from tyre.ProductTextTranslation where "
			+ "ProductId = "+prodID+" and TextRoleId = "+DescTxt+" and CountryCode = '"+lang+"'";
		return getProdTxt;
	}
	
	public static final String queryNoOfFristProd(Integer marketID, String masterName){
		String noOfFristProd = "select count(*)AS RESULT from (Select pv.* from Tyre.ProductVariant pv " 
				+ "JOIN Tyre.VariantMarket vm on vm.ProductVariantId = pv.ProductVariantId "
				+ "JOIN Tyre.ProductMasterData ma on ma.ProductId = pv.ProductId "
				+ "WHERE vm.MarketId = "+marketID+" and ma.MasterName = '" + masterName + "') myNewTable";
		return noOfFristProd;
	}
	
	public static final String queryCountNoOfTyreSizeByFirstProd(Integer marketID, String masterName){
		String countNoOfTyreSizeByFirstProd = "Select pv.* from Tyre.ProductVariant pv "
				+ "JOIN Tyre.VariantMarket vm on vm.ProductVariantId = pv.ProductVariantId "
				+ "JOIN Tyre.ProductMasterData ma on ma.ProductId = pv.ProductId "
				+ "WHERE vm.MarketId = "+marketID+" and ma.MasterName = '"+masterName+"'";
		return countNoOfTyreSizeByFirstProd;
	}
	
	public static final String queryGetValuesOfTyre(String prodVariantID){
		String getValuesOfTyre = "select DISTINCT vp.* from Tyre.VariantProperty vp "
				+ "where vp.propertyid in ("+Width+","+AspectR+","+RimSize+","+LoadIndex+","+SpeedRating+") and vp.ProductVariantId = "+prodVariantID+"";
		return getValuesOfTyre;
	}
	
	public static final String queryFilterBy(Integer marketID, String classID){
		String filterBy = "select DISTINCT MasterName  from Tyre.ProductMasterData pm "
				+ "JOIN Tyre.ProductVariant pv on pm.ProductId = pv.ProductId "
				+ "Join Tyre.VariantMarket vm on vm.ProductVariantId = pv.ProductVariantId "
				+ "where vm.MarketId = "+marketID + " and ProductClassId = " + classID	+ " and BrandId = 4 and pm.Detele_Flg = 0";
		return filterBy;
	}
	
	public static final String queryTerrainFilterBy(Integer marketID, String classID, String terrain){
		String terrainFilterBy = "Select  distinct ma.MasterName from Tyre.ProductVariant pv "
				+"JOIN Tyre.VariantProperty vp on   vp.ProductVariantId = pv.ProductVariantId "
				+"Join Tyre.VariantMarket vm on vm.ProductVariantId = vp.ProductVariantId "
				+"JOIN Tyre.ProductMasterData ma on ma.ProductId = pv.ProductId " 
				+"where vm.MarketId = "+marketID + " and ma.ProductClassId =" + classID	+ " and Detele_Flg = 0 and BrandId =4 " 
				+"and vp.ProductVariantId in (select ProductVariantId from tyre.VariantProperty where propertyid = 326 and value like '%" + terrain	+ "%')";
		return terrainFilterBy;
	}
	
	public static final String queryProdRangeFilterBy(Integer marketID, String classID, String terrain){
		String prodRangeFilterBy = "Select  distinct ma.MasterName from Tyre.ProductVariant pv "
				+"JOIN Tyre.VariantProperty vp on   vp.ProductVariantId = pv.ProductVariantId "
				+"Join Tyre.VariantMarket vm on vm.ProductVariantId = vp.ProductVariantId "
				+"JOIN Tyre.ProductMasterData ma on ma.ProductId = pv.ProductId " 
				+"where vm.MarketId = "+marketID + " and ma.ProductClassId =" + classID	+ " and Detele_Flg = 0 and BrandId =4 " 
				+"and vp.ProductVariantId in (select ProductVariantId from tyre.VariantProperty where propertyid = 327 and value like '%" + terrain	+ "%')";
		return prodRangeFilterBy;
	}
		
	public static final String queryGetProdBenefits(String prodID){
		String getProdTagTxtBenefitsFeatures = "select * from tyre.ProductTextTranslation where "
			+"ProductId = "+prodID+" and TextRoleId  in ( "+BenefitsTxt[0]+", "+BenefitsTxt[1]+", "+BenefitsTxt[2]+") "
			+ "and countrycode = '"+lang+"'";
		return getProdTagTxtBenefitsFeatures;
	}
	
	public static final String queryGetProdFeatures(String prodID){
		String getProdTagTxtBenefitsFeatures = "select * from tyre.ProductTextTranslation where "
			+"ProductId = "+prodID+" and TextRoleId  in ( "+FeaturesTxt[0]+", "+FeaturesTxt[1]+", "+FeaturesTxt[2]+") "
			+ "and countrycode = '"+lang+"'";
		return getProdTagTxtBenefitsFeatures;
	}
	
	public static final String queryGetProdRtb(String prodID){
		String getProdTagTxtBenefitsFeatures = "select * from tyre.ProductTextTranslation where "
			+"ProductId = "+prodID+" and TextRoleId  in ( "+RtbTxt[0]+","+RtbTxt[1]+","+RtbTxt[2]+") "
			+ "and countrycode = '"+lang+"'";
		return getProdTagTxtBenefitsFeatures;
	}
	
	public static final String queryGetRTBDisclaimer(String prodID){
		String getRTBDisclaimer = "select * from tyre.ProductText where ProductId = "+prodID+" and TextRoleId  = 1041";
		return getRTBDisclaimer;
	}
	
	public static final String queryGetRimSizeDDL(String prodVariantID){
		String getRimSizeDDL = "select distinct Value from tyre.VariantProperty where ProductVariantId in("+prodVariantID+") and PropertyId ="+RimSize+"";
		return getRimSizeDDL;
	}
	
	public static final String queryCheckWidthValueInDDL(Integer marketID){
		String checkWidthValueInDDL = " select distinct vp.value, vp.PropertyId  from tyre.VariantProperty vp "
				+"inner join tyre.VariantMarket vm on vp.ProductVariantId = vm.ProductVariantId " 
				+"inner join tyre.ProductVariant pv on vp.ProductVariantId = pv.ProductVariantId " 
				+"inner join tyre.ProductMasterData pm on pv.ProductId = pm.ProductId "  
				+"and vp.PropertyId = "+Width+" "
				+"and vm.MarketId= "+marketID + " "
				+"and pm.ProductClassId in ("+PVClass[0]+", "+PVClass[1]+", "+PVClass[2]+")  and pm.BrandId = 4 and pm.Detele_Flg =0";
		return checkWidthValueInDDL;
	}
	
	public static final String queryCheckAspectValueInDDL(Integer marketID){
		String checkAspectValueInDDL = " select distinct vp.value, vp.PropertyId  from tyre.VariantProperty vp "
				+"inner join tyre.VariantMarket vm on vp.ProductVariantId = vm.ProductVariantId " 
				+"inner join tyre.ProductVariant pv on vp.ProductVariantId = pv.ProductVariantId " 
				+"inner join tyre.ProductMasterData pm on pv.ProductId = pm.ProductId "  
				+"and vp.PropertyId = "+AspectR+" "
				+"and vm.MarketId= "+marketID + " "
				+"and pm.ProductClassId in ("+PVClass[0]+", "+PVClass[1]+", "+PVClass[2]+")  and pm.BrandId = 4 and pm.Detele_Flg =0";
		return checkAspectValueInDDL;
	}
	
	public static final String queryCheckRimValueInDDL(Integer marketID){
		String checkRimValueInDDL = " select distinct vp.value, vp.PropertyId  from tyre.VariantProperty vp "
				+"inner join tyre.VariantMarket vm on vp.ProductVariantId = vm.ProductVariantId " 
				+"inner join tyre.ProductVariant pv on vp.ProductVariantId = pv.ProductVariantId " 
				+"inner join tyre.ProductMasterData pm on pv.ProductId = pm.ProductId "  
				+"and vp.PropertyId = "+RimSize+" "
				+"and vm.MarketId= "+marketID + " "
				+"and pm.ProductClassId in ("+PVClass[0]+", "+PVClass[1]+", "+PVClass[2]+")  and pm.BrandId = 4 and pm.Detele_Flg =0";
		return checkRimValueInDDL;
	}
	
	public static final String querySelectValueInWidthDDL(Integer marketID, String propertyID){
		String selectValueInWidthDDL = "select distinct vp.value, vp.PropertyId  from tyre.VariantProperty vp "
				+"inner join tyre.VariantMarket vm on vp.ProductVariantId = vm.ProductVariantId " 
				+"inner join tyre.ProductVariant pv on vp.ProductVariantId = pv.ProductVariantId " 
				+"inner join tyre.ProductMasterData pm on pv.ProductId = pm.ProductId "  
				+"and vp.PropertyId = "+propertyID + " "
				+"and vm.MarketId= "+marketID + " "
				+"and pm.ProductClassId in ("+PVClass[0]+", "+PVClass[1]+", "+PVClass[2]+")  and pm.BrandId = 4 and pm.Detele_Flg =0 "
				+"and vp.ProductVariantId in (select ProductVariantId from tyre.VariantProperty where propertyid = "+Width+" and value like '21%')"
				+"order by vp.value";
		return selectValueInWidthDDL;
	}
	
	public static final String querySelectValueInAspectDDL(Integer marketID){
		String selectValueInAspectDDL = "select distinct vp.value, vp.PropertyId  from tyre.VariantProperty vp "
				+"inner join tyre.VariantMarket vm on vp.ProductVariantId = vm.ProductVariantId " 
				+"inner join tyre.ProductVariant pv on vp.ProductVariantId = pv.ProductVariantId "
				+"inner join tyre.ProductMasterData pm on pv.ProductId = pm.ProductId "  
				+"and vp.PropertyId in ("+RimSize+") "
				+"and vm.MarketId= "+marketID + " "
				+"and pm.ProductClassId in ("+PVClass[0]+", "+PVClass[1]+", "+PVClass[2]+")  and pm.BrandId = 4 and pm.Detele_Flg =0 "
				+"and vp.ProductVariantId in (select ProductVariantId from tyre.VariantProperty where propertyid = "+Width+" and value like '21%') "
				+"and vp.ProductVariantId in (select ProductVariantId from tyre.VariantProperty where propertyid = "+AspectR+" and value like '70%') "
				+"order by vp.value";
		return selectValueInAspectDDL;
	}
	
	public static final String queryGetProdNameByID(String prodID){
		String getProdNameByID = "select * from Tyre.ProductMasterData where productID = "+prodID+"";
		return getProdNameByID;
	}
	
	public static final String queryGetProductNameAfterSearch(Integer marketID, String widthValue, String aspectValue, String rimValue){
		String getProductNameAfterSearch = "Select distinct pv.*,ma.MasterName from Tyre.ProductVariant pv "
				+"JOIN Tyre.VariantProperty vp on vp.ProductVariantId = pv.ProductVariantId "
				+"Join Tyre.VariantMarket vm on vm.ProductVariantId = vp.ProductVariantId "
				+"JOIN Tyre.ProductMasterData ma on ma.ProductId = pv.ProductId "
				+"where vm.MarketId = "+marketID + " and ma.ProductClassId in ("+PVClass[0]+", "+PVClass[1]+", "+PVClass[2]+") and Detele_Flg = 0 and BrandId =4 " 
				+"and vp.ProductVariantId in (select ProductVariantId from tyre.VariantProperty where propertyid = "+Width+" and value like '"+widthValue+"%')"
				+"and vp.ProductVariantId in (select ProductVariantId from tyre.VariantProperty where propertyid = "+AspectR+" and value like '"+aspectValue+"%')"
				+"and vp.ProductVariantId in (select ProductVariantId from tyre.VariantProperty where propertyid = "+RimSize+" and value like '"+rimValue+"%')";
		return getProductNameAfterSearch;
	}
	
	public static final String queryGetValueAfterSearch(String prodVariantID){
		String getValueAfterSearch = "select * from tyre.VariantProperty where ProductVariantId = "+prodVariantID+" "
				+ "and PropertyId in ("+Lifespan+","+Warranty+","+Braking+","+Comfort+") order by ProductVariantId asc";
		return getValueAfterSearch;
	}
}
