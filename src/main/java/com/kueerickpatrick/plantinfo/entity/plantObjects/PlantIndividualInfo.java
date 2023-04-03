package com.kueerickpatrick.plantinfo.entity.plantObjects;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlantIndividualInfo{

	@JsonProperty("medicinal_use")
	private String medicinalUse;

	@JsonProperty("endangered")
	private String endangered;

	@JsonProperty("type")
	private String type;

	@JsonProperty("salt_tolerant")
	private boolean saltTolerant;

	@JsonProperty("leaf_color")
	private List<String> leafColor;

	@JsonProperty("poison_effects_to_pets")
	private String poisonEffectsToPets;

	@JsonProperty("growth_rate")
	private String growthRate;

	@JsonProperty("problem")
	private String problem;

	@JsonProperty("harvest_season")
	private String harvestSeason;

	@JsonProperty("cones")
	private boolean cones;

	@JsonProperty("rare")
	private String rare;

	@JsonProperty("attracts")
	private List<Object> attracts;

	@JsonProperty("poison_effects_to_humans")
	private String poisonEffectsToHumans;

	@JsonProperty("id")
	private int id;

	@JsonProperty("common_name")
	private String commonName;

	@JsonProperty("cuisine_list")
	private String cuisineList;

	@JsonProperty("endangered_level")
	private String endangeredLevel;

	@JsonProperty("pest_susceptibility")
	private String pestSusceptibility;

	@JsonProperty("edible_fruit_taste_profile")
	private String edibleFruitTasteProfile;

	@JsonProperty("flowers")
	private boolean flowers;

	@JsonProperty("invasive")
	private boolean invasive;

	@JsonProperty("scientific_name")
	private List<String> scientificName;

	@JsonProperty("poisonous_to_humans")
	private String poisonousToHumans;

	@JsonProperty("leaf_nutritional_value")
	private String leafNutritionalValue;

	@JsonProperty("poison_to_humans_cure")
	private String poisonToHumansCure;

	@JsonProperty("propagation")
	private List<String> propagation;

	@JsonProperty("indoor")
	private boolean indoor;

	@JsonProperty("default_image")
	private DefaultImage defaultImage;

	@JsonProperty("thorny")
	private boolean thorny;

	@JsonProperty("edible_leaf_taste_profile")
	private String edibleLeafTasteProfile;

	@JsonProperty("flowering_season")
	private String floweringSeason;

	@JsonProperty("origin")
	private List<String> origin;

	@JsonProperty("hardiness_location_image")
	private String hardinessLocationImage;

	@JsonProperty("edible_fruit")
	private boolean edibleFruit;

	@JsonProperty("fruit_nutritional_value")
	private String fruitNutritionalValue;

	@JsonProperty("description")
	private String description;

	@JsonProperty("soil")
	private List<Object> soil;

	@JsonProperty("harvest_method")
	private String harvestMethod;

	@JsonProperty("medicinal")
	private String medicinal;

	@JsonProperty("cycle")
	private String cycle;

	@JsonProperty("fruits")
	private boolean fruits;

	@JsonProperty("poison_to_pets_cure")
	private String poisonToPetsCure;

	@JsonProperty("rare_level")
	private String rareLevel;

	@JsonProperty("dimension")
	private String dimension;

	@JsonProperty("drought_tolerant")
	private boolean droughtTolerant;

	@JsonProperty("cuisine")
	private boolean cuisine;

	@JsonProperty("leaf")
	private boolean leaf;

	@JsonProperty("fruiting_season")
	private String fruitingSeason;

	@JsonProperty("hardiness")
	private Hardiness hardiness;

	@JsonProperty("tropical")
	private boolean tropical;

	@JsonProperty("sunlight")
	private List<String> sunlight;

	@JsonProperty("watering")
	private String watering;

	@JsonProperty("flower_color")
	private String flowerColor;

	@JsonProperty("fruit_color")
	private List<Object> fruitColor;

	@JsonProperty("medicinal_method")
	private String medicinalMethod;

	@JsonProperty("pest_susceptibility_api")
	private String pestSusceptibilityApi;

	@JsonProperty("poisonous_to_pets")
	private String poisonousToPets;

	@JsonProperty("care_level")
	private String careLevel;

	@JsonProperty("other_name")
	private List<String> otherName;

	@JsonProperty("edible_leaf")
	private boolean edibleLeaf;

	@JsonProperty("family")
	private Object family;

	@JsonProperty("maintenance")
	private Object maintenance;

	public void setMedicinalUse(String medicinalUse){
		this.medicinalUse = medicinalUse;
	}

	public String getMedicinalUse(){
		return medicinalUse;
	}

	public void setEndangered(String endangered){
		this.endangered = endangered;
	}

	public String getEndangered(){
		return endangered;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setSaltTolerant(boolean saltTolerant){
		this.saltTolerant = saltTolerant;
	}

	public boolean isSaltTolerant(){
		return saltTolerant;
	}

	public void setLeafColor(List<String> leafColor){
		this.leafColor = leafColor;
	}

	public List<String> getLeafColor(){
		return leafColor;
	}

	public void setPoisonEffectsToPets(String poisonEffectsToPets){
		this.poisonEffectsToPets = poisonEffectsToPets;
	}

	public String getPoisonEffectsToPets(){
		return poisonEffectsToPets;
	}

	public void setGrowthRate(String growthRate){
		this.growthRate = growthRate;
	}

	public String getGrowthRate(){
		return growthRate;
	}

	public void setProblem(String problem){
		this.problem = problem;
	}

	public String getProblem(){
		return problem;
	}

	public void setHarvestSeason(String harvestSeason){
		this.harvestSeason = harvestSeason;
	}

	public String getHarvestSeason(){
		return harvestSeason;
	}

	public void setCones(boolean cones){
		this.cones = cones;
	}

	public boolean isCones(){
		return cones;
	}

	public void setRare(String rare){
		this.rare = rare;
	}

	public String getRare(){
		return rare;
	}

	public void setAttracts(List<Object> attracts){
		this.attracts = attracts;
	}

	public List<Object> getAttracts(){
		return attracts;
	}

	public void setPoisonEffectsToHumans(String poisonEffectsToHumans){
		this.poisonEffectsToHumans = poisonEffectsToHumans;
	}

	public String getPoisonEffectsToHumans(){
		return poisonEffectsToHumans;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCommonName(String commonName){
		this.commonName = commonName;
	}

	public String getCommonName(){
		return commonName;
	}

	public void setCuisineList(String cuisineList){
		this.cuisineList = cuisineList;
	}

	public String getCuisineList(){
		return cuisineList;
	}

	public void setEndangeredLevel(String endangeredLevel){
		this.endangeredLevel = endangeredLevel;
	}

	public String getEndangeredLevel(){
		return endangeredLevel;
	}

	public void setPestSusceptibility(String pestSusceptibility){
		this.pestSusceptibility = pestSusceptibility;
	}

	public String getPestSusceptibility(){
		return pestSusceptibility;
	}

	public void setEdibleFruitTasteProfile(String edibleFruitTasteProfile){
		this.edibleFruitTasteProfile = edibleFruitTasteProfile;
	}

	public String getEdibleFruitTasteProfile(){
		return edibleFruitTasteProfile;
	}

	public void setFlowers(boolean flowers){
		this.flowers = flowers;
	}

	public boolean isFlowers(){
		return flowers;
	}

	public void setInvasive(boolean invasive){
		this.invasive = invasive;
	}

	public boolean isInvasive(){
		return invasive;
	}

	public void setScientificName(List<String> scientificName){
		this.scientificName = scientificName;
	}

	public List<String> getScientificName(){
		return scientificName;
	}

	public void setPoisonousToHumans(String poisonousToHumans){
		this.poisonousToHumans = poisonousToHumans;
	}

	public String getPoisonousToHumans(){
		return poisonousToHumans;
	}

	public void setLeafNutritionalValue(String leafNutritionalValue){
		this.leafNutritionalValue = leafNutritionalValue;
	}

	public String getLeafNutritionalValue(){
		return leafNutritionalValue;
	}

	public void setPoisonToHumansCure(String poisonToHumansCure){
		this.poisonToHumansCure = poisonToHumansCure;
	}

	public String getPoisonToHumansCure(){
		return poisonToHumansCure;
	}

	public void setPropagation(List<String> propagation){
		this.propagation = propagation;
	}

	public List<String> getPropagation(){
		return propagation;
	}

	public void setIndoor(boolean indoor){
		this.indoor = indoor;
	}

	public boolean isIndoor(){
		return indoor;
	}

	public void setDefaultImage(DefaultImage defaultImage){
		this.defaultImage = defaultImage;
	}

	public DefaultImage getDefaultImage(){
		return defaultImage;
	}

	public void setThorny(boolean thorny){
		this.thorny = thorny;
	}

	public boolean isThorny(){
		return thorny;
	}

	public void setEdibleLeafTasteProfile(String edibleLeafTasteProfile){
		this.edibleLeafTasteProfile = edibleLeafTasteProfile;
	}

	public String getEdibleLeafTasteProfile(){
		return edibleLeafTasteProfile;
	}

	public void setFloweringSeason(String floweringSeason){
		this.floweringSeason = floweringSeason;
	}

	public String getFloweringSeason(){
		return floweringSeason;
	}

	public void setOrigin(List<String> origin){
		this.origin = origin;
	}

	public List<String> getOrigin(){
		return origin;
	}

	public void setHardinessLocationImage(String hardinessLocationImage){
		this.hardinessLocationImage = hardinessLocationImage;
	}

	public String getHardinessLocationImage(){
		return hardinessLocationImage;
	}

	public void setEdibleFruit(boolean edibleFruit){
		this.edibleFruit = edibleFruit;
	}

	public boolean isEdibleFruit(){
		return edibleFruit;
	}

	public void setFruitNutritionalValue(String fruitNutritionalValue){
		this.fruitNutritionalValue = fruitNutritionalValue;
	}

	public String getFruitNutritionalValue(){
		return fruitNutritionalValue;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setSoil(List<Object> soil){
		this.soil = soil;
	}

	public List<Object> getSoil(){
		return soil;
	}

	public void setHarvestMethod(String harvestMethod){
		this.harvestMethod = harvestMethod;
	}

	public String getHarvestMethod(){
		return harvestMethod;
	}

	public void setMedicinal(String medicinal){
		this.medicinal = medicinal;
	}

	public String getMedicinal(){
		return medicinal;
	}

	public void setCycle(String cycle){
		this.cycle = cycle;
	}

	public String getCycle(){
		return cycle;
	}

	public void setFruits(boolean fruits){
		this.fruits = fruits;
	}

	public boolean isFruits(){
		return fruits;
	}

	public void setPoisonToPetsCure(String poisonToPetsCure){
		this.poisonToPetsCure = poisonToPetsCure;
	}

	public String getPoisonToPetsCure(){
		return poisonToPetsCure;
	}

	public void setRareLevel(String rareLevel){
		this.rareLevel = rareLevel;
	}

	public String getRareLevel(){
		return rareLevel;
	}

	public void setDimension(String dimension){
		this.dimension = dimension;
	}

	public String getDimension(){
		return dimension;
	}

	public void setDroughtTolerant(boolean droughtTolerant){
		this.droughtTolerant = droughtTolerant;
	}

	public boolean isDroughtTolerant(){
		return droughtTolerant;
	}

	public void setCuisine(boolean cuisine){
		this.cuisine = cuisine;
	}

	public boolean isCuisine(){
		return cuisine;
	}

	public void setLeaf(boolean leaf){
		this.leaf = leaf;
	}

	public boolean isLeaf(){
		return leaf;
	}

	public void setFruitingSeason(String fruitingSeason){
		this.fruitingSeason = fruitingSeason;
	}

	public String getFruitingSeason(){
		return fruitingSeason;
	}

	public void setHardiness(Hardiness hardiness){
		this.hardiness = hardiness;
	}

	public Hardiness getHardiness(){
		return hardiness;
	}

	public void setTropical(boolean tropical){
		this.tropical = tropical;
	}

	public boolean isTropical(){
		return tropical;
	}

	public void setSunlight(List<String> sunlight){
		this.sunlight = sunlight;
	}

	public List<String> getSunlight(){
		return sunlight;
	}

	public void setWatering(String watering){
		this.watering = watering;
	}

	public String getWatering(){
		return watering;
	}

	public void setFlowerColor(String flowerColor){
		this.flowerColor = flowerColor;
	}

	public String getFlowerColor(){
		return flowerColor;
	}

	public void setFruitColor(List<Object> fruitColor){
		this.fruitColor = fruitColor;
	}

	public List<Object> getFruitColor(){
		return fruitColor;
	}

	public void setMedicinalMethod(String medicinalMethod){
		this.medicinalMethod = medicinalMethod;
	}

	public String getMedicinalMethod(){
		return medicinalMethod;
	}

	public void setPestSusceptibilityApi(String pestSusceptibilityApi){
		this.pestSusceptibilityApi = pestSusceptibilityApi;
	}

	public String getPestSusceptibilityApi(){
		return pestSusceptibilityApi;
	}

	public void setPoisonousToPets(String poisonousToPets){
		this.poisonousToPets = poisonousToPets;
	}

	public String getPoisonousToPets(){
		return poisonousToPets;
	}

	public void setCareLevel(String careLevel){
		this.careLevel = careLevel;
	}

	public String getCareLevel(){
		return careLevel;
	}

	public void setOtherName(List<String> otherName){
		this.otherName = otherName;
	}

	public List<String> getOtherName(){
		return otherName;
	}

	public void setEdibleLeaf(boolean edibleLeaf){
		this.edibleLeaf = edibleLeaf;
	}

	public boolean isEdibleLeaf(){
		return edibleLeaf;
	}

	public void setFamily(Object family){
		this.family = family;
	}

	public Object getFamily(){
		return family;
	}

	public void setMaintenance(Object maintenance){
		this.maintenance = maintenance;
	}

	public Object getMaintenance(){
		return maintenance;
	}

	@Override
 	public String toString(){
		return 
			"PlantIndividualInfo{" + 
			"medicinal_use = '" + medicinalUse + '\'' + 
			",endangered = '" + endangered + '\'' + 
			",type = '" + type + '\'' + 
			",salt_tolerant = '" + saltTolerant + '\'' + 
			",leaf_color = '" + leafColor + '\'' + 
			",poison_effects_to_pets = '" + poisonEffectsToPets + '\'' + 
			",growth_rate = '" + growthRate + '\'' + 
			",problem = '" + problem + '\'' + 
			",harvest_season = '" + harvestSeason + '\'' + 
			",cones = '" + cones + '\'' + 
			",rare = '" + rare + '\'' + 
			",attracts = '" + attracts + '\'' + 
			",poison_effects_to_humans = '" + poisonEffectsToHumans + '\'' + 
			",id = '" + id + '\'' + 
			",common_name = '" + commonName + '\'' + 
			",cuisine_list = '" + cuisineList + '\'' + 
			",endangered_level = '" + endangeredLevel + '\'' + 
			",pest_susceptibility = '" + pestSusceptibility + '\'' + 
			",edible_fruit_taste_profile = '" + edibleFruitTasteProfile + '\'' + 
			",flowers = '" + flowers + '\'' + 
			",invasive = '" + invasive + '\'' + 
			",scientific_name = '" + scientificName + '\'' + 
			",poisonous_to_humans = '" + poisonousToHumans + '\'' + 
			",leaf_nutritional_value = '" + leafNutritionalValue + '\'' + 
			",poison_to_humans_cure = '" + poisonToHumansCure + '\'' + 
			",propagation = '" + propagation + '\'' + 
			",indoor = '" + indoor + '\'' + 
			",default_image = '" + defaultImage + '\'' + 
			",thorny = '" + thorny + '\'' + 
			",edible_leaf_taste_profile = '" + edibleLeafTasteProfile + '\'' + 
			",flowering_season = '" + floweringSeason + '\'' + 
			",origin = '" + origin + '\'' + 
			",hardiness_location_image = '" + hardinessLocationImage + '\'' + 
			",edible_fruit = '" + edibleFruit + '\'' + 
			",fruit_nutritional_value = '" + fruitNutritionalValue + '\'' + 
			",description = '" + description + '\'' + 
			",soil = '" + soil + '\'' + 
			",harvest_method = '" + harvestMethod + '\'' + 
			",medicinal = '" + medicinal + '\'' + 
			",cycle = '" + cycle + '\'' + 
			",fruits = '" + fruits + '\'' + 
			",poison_to_pets_cure = '" + poisonToPetsCure + '\'' + 
			",rare_level = '" + rareLevel + '\'' + 
			",dimension = '" + dimension + '\'' + 
			",drought_tolerant = '" + droughtTolerant + '\'' + 
			",cuisine = '" + cuisine + '\'' + 
			",leaf = '" + leaf + '\'' + 
			",fruiting_season = '" + fruitingSeason + '\'' + 
			",hardiness = '" + hardiness + '\'' + 
			",tropical = '" + tropical + '\'' + 
			",sunlight = '" + sunlight + '\'' + 
			",watering = '" + watering + '\'' + 
			",flower_color = '" + flowerColor + '\'' + 
			",fruit_color = '" + fruitColor + '\'' + 
			",medicinal_method = '" + medicinalMethod + '\'' + 
			",pest_susceptibility_api = '" + pestSusceptibilityApi + '\'' + 
			",poisonous_to_pets = '" + poisonousToPets + '\'' + 
			",care_level = '" + careLevel + '\'' + 
			",other_name = '" + otherName + '\'' + 
			",edible_leaf = '" + edibleLeaf + '\'' + 
			",family = '" + family + '\'' + 
			",maintenance = '" + maintenance + '\'' + 
			"}";
		}
}