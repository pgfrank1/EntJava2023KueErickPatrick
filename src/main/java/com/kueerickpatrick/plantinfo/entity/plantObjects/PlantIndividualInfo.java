package com.kueerickpatrick.plantinfo.entity.plantObjects;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Plant individual info.
 *
 * @author pgfrank
 * @version 1.0
 * @since 1.0
 */
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

	/**
	 * Set medicinal use.
	 *
	 * @param medicinalUse the medicinal use
	 */
	public void setMedicinalUse(String medicinalUse){
		this.medicinalUse = medicinalUse;
	}

	/**
	 * Get medicinal use string.
	 *
	 * @return the string
	 */
	public String getMedicinalUse(){
		return medicinalUse;
	}

	/**
	 * Set endangered.
	 *
	 * @param endangered the endangered
	 */
	public void setEndangered(String endangered){
		this.endangered = endangered;
	}

	/**
	 * Get endangered string.
	 *
	 * @return the string
	 */
	public String getEndangered(){
		return endangered;
	}

	/**
	 * Set type.
	 *
	 * @param type the type
	 */
	public void setType(String type){
		this.type = type;
	}

	/**
	 * Get type string.
	 *
	 * @return the string
	 */
	public String getType(){
		return type;
	}

	/**
	 * Set salt tolerant.
	 *
	 * @param saltTolerant the salt tolerant
	 */
	public void setSaltTolerant(boolean saltTolerant){
		this.saltTolerant = saltTolerant;
	}

	/**
	 * Is salt tolerant boolean.
	 *
	 * @return the boolean
	 */
	public boolean isSaltTolerant(){
		return saltTolerant;
	}

	/**
	 * Set leaf color.
	 *
	 * @param leafColor the leaf color
	 */
	public void setLeafColor(List<String> leafColor){
		this.leafColor = leafColor;
	}

	/**
	 * Get leaf color list.
	 *
	 * @return the list
	 */
	public List<String> getLeafColor(){
		return leafColor;
	}

	/**
	 * Set poison effects to pets.
	 *
	 * @param poisonEffectsToPets the poison effects to pets
	 */
	public void setPoisonEffectsToPets(String poisonEffectsToPets){
		this.poisonEffectsToPets = poisonEffectsToPets;
	}

	/**
	 * Get poison effects to pets string.
	 *
	 * @return the string
	 */
	public String getPoisonEffectsToPets(){
		return poisonEffectsToPets;
	}

	/**
	 * Set growth rate.
	 *
	 * @param growthRate the growth rate
	 */
	public void setGrowthRate(String growthRate){
		this.growthRate = growthRate;
	}

	/**
	 * Get growth rate string.
	 *
	 * @return the string
	 */
	public String getGrowthRate(){
		return growthRate;
	}

	/**
	 * Set problem.
	 *
	 * @param problem the problem
	 */
	public void setProblem(String problem){
		this.problem = problem;
	}

	/**
	 * Get problem string.
	 *
	 * @return the string
	 */
	public String getProblem(){
		return problem;
	}

	/**
	 * Set harvest season.
	 *
	 * @param harvestSeason the harvest season
	 */
	public void setHarvestSeason(String harvestSeason){
		this.harvestSeason = harvestSeason;
	}

	/**
	 * Get harvest season string.
	 *
	 * @return the string
	 */
	public String getHarvestSeason(){
		return harvestSeason;
	}

	/**
	 * Set cones.
	 *
	 * @param cones the cones
	 */
	public void setCones(boolean cones){
		this.cones = cones;
	}

	/**
	 * Is cones boolean.
	 *
	 * @return the boolean
	 */
	public boolean isCones(){
		return cones;
	}

	/**
	 * Set rare.
	 *
	 * @param rare the rare
	 */
	public void setRare(String rare){
		this.rare = rare;
	}

	/**
	 * Get rare string.
	 *
	 * @return the string
	 */
	public String getRare(){
		return rare;
	}

	/**
	 * Set attracts.
	 *
	 * @param attracts the attracts
	 */
	public void setAttracts(List<Object> attracts){
		this.attracts = attracts;
	}

	/**
	 * Get attracts list.
	 *
	 * @return the list
	 */
	public List<Object> getAttracts(){
		return attracts;
	}

	/**
	 * Set poison effects to humans.
	 *
	 * @param poisonEffectsToHumans the poison effects to humans
	 */
	public void setPoisonEffectsToHumans(String poisonEffectsToHumans){
		this.poisonEffectsToHumans = poisonEffectsToHumans;
	}

	/**
	 * Get poison effects to humans string.
	 *
	 * @return the string
	 */
	public String getPoisonEffectsToHumans(){
		return poisonEffectsToHumans;
	}

	/**
	 * Set id.
	 *
	 * @param id the id
	 */
	public void setId(int id){
		this.id = id;
	}

	/**
	 * Get id int.
	 *
	 * @return the int
	 */
	public int getId(){
		return id;
	}

	/**
	 * Set common name.
	 *
	 * @param commonName the common name
	 */
	public void setCommonName(String commonName){
		this.commonName = commonName;
	}

	/**
	 * Get common name string.
	 *
	 * @return the string
	 */
	public String getCommonName(){
		return commonName;
	}

	/**
	 * Set cuisine list.
	 *
	 * @param cuisineList the cuisine list
	 */
	public void setCuisineList(String cuisineList){
		this.cuisineList = cuisineList;
	}

	/**
	 * Get cuisine list string.
	 *
	 * @return the string
	 */
	public String getCuisineList(){
		return cuisineList;
	}

	/**
	 * Set endangered level.
	 *
	 * @param endangeredLevel the endangered level
	 */
	public void setEndangeredLevel(String endangeredLevel){
		this.endangeredLevel = endangeredLevel;
	}

	/**
	 * Get endangered level string.
	 *
	 * @return the string
	 */
	public String getEndangeredLevel(){
		return endangeredLevel;
	}

	/**
	 * Set pest susceptibility.
	 *
	 * @param pestSusceptibility the pest susceptibility
	 */
	public void setPestSusceptibility(String pestSusceptibility){
		this.pestSusceptibility = pestSusceptibility;
	}

	/**
	 * Get pest susceptibility string.
	 *
	 * @return the string
	 */
	public String getPestSusceptibility(){
		return pestSusceptibility;
	}

	/**
	 * Set edible fruit taste profile.
	 *
	 * @param edibleFruitTasteProfile the edible fruit taste profile
	 */
	public void setEdibleFruitTasteProfile(String edibleFruitTasteProfile){
		this.edibleFruitTasteProfile = edibleFruitTasteProfile;
	}

	/**
	 * Get edible fruit taste profile string.
	 *
	 * @return the string
	 */
	public String getEdibleFruitTasteProfile(){
		return edibleFruitTasteProfile;
	}

	/**
	 * Set flowers.
	 *
	 * @param flowers the flowers
	 */
	public void setFlowers(boolean flowers){
		this.flowers = flowers;
	}

	/**
	 * Is flowers boolean.
	 *
	 * @return the boolean
	 */
	public boolean isFlowers(){
		return flowers;
	}

	/**
	 * Set invasive.
	 *
	 * @param invasive the invasive
	 */
	public void setInvasive(boolean invasive){
		this.invasive = invasive;
	}

	/**
	 * Is invasive boolean.
	 *
	 * @return the boolean
	 */
	public boolean isInvasive(){
		return invasive;
	}

	/**
	 * Set scientific name.
	 *
	 * @param scientificName the scientific name
	 */
	public void setScientificName(List<String> scientificName){
		this.scientificName = scientificName;
	}

	/**
	 * Get scientific name list.
	 *
	 * @return the list
	 */
	public List<String> getScientificName(){
		return scientificName;
	}

	/**
	 * Set poisonous to humans.
	 *
	 * @param poisonousToHumans the poisonous to humans
	 */
	public void setPoisonousToHumans(String poisonousToHumans){
		this.poisonousToHumans = poisonousToHumans;
	}

	/**
	 * Get poisonous to humans string.
	 *
	 * @return the string
	 */
	public String getPoisonousToHumans(){
		return poisonousToHumans;
	}

	/**
	 * Set leaf nutritional value.
	 *
	 * @param leafNutritionalValue the leaf nutritional value
	 */
	public void setLeafNutritionalValue(String leafNutritionalValue){
		this.leafNutritionalValue = leafNutritionalValue;
	}

	/**
	 * Get leaf nutritional value string.
	 *
	 * @return the string
	 */
	public String getLeafNutritionalValue(){
		return leafNutritionalValue;
	}

	/**
	 * Set poison to humans cure.
	 *
	 * @param poisonToHumansCure the poison to humans cure
	 */
	public void setPoisonToHumansCure(String poisonToHumansCure){
		this.poisonToHumansCure = poisonToHumansCure;
	}

	/**
	 * Get poison to humans cure string.
	 *
	 * @return the string
	 */
	public String getPoisonToHumansCure(){
		return poisonToHumansCure;
	}

	/**
	 * Set propagation.
	 *
	 * @param propagation the propagation
	 */
	public void setPropagation(List<String> propagation){
		this.propagation = propagation;
	}

	/**
	 * Get propagation list.
	 *
	 * @return the list
	 */
	public List<String> getPropagation(){
		return propagation;
	}

	/**
	 * Set indoor.
	 *
	 * @param indoor the indoor
	 */
	public void setIndoor(boolean indoor){
		this.indoor = indoor;
	}

	/**
	 * Is indoor boolean.
	 *
	 * @return the boolean
	 */
	public boolean isIndoor(){
		return indoor;
	}

	/**
	 * Set default image.
	 *
	 * @param defaultImage the default image
	 */
	public void setDefaultImage(DefaultImage defaultImage){
		this.defaultImage = defaultImage;
	}

	/**
	 * Get default image default image.
	 *
	 * @return the default image
	 */
	public DefaultImage getDefaultImage(){
		return defaultImage;
	}

	/**
	 * Set thorny.
	 *
	 * @param thorny the thorny
	 */
	public void setThorny(boolean thorny){
		this.thorny = thorny;
	}

	/**
	 * Is thorny boolean.
	 *
	 * @return the boolean
	 */
	public boolean isThorny(){
		return thorny;
	}

	/**
	 * Set edible leaf taste profile.
	 *
	 * @param edibleLeafTasteProfile the edible leaf taste profile
	 */
	public void setEdibleLeafTasteProfile(String edibleLeafTasteProfile){
		this.edibleLeafTasteProfile = edibleLeafTasteProfile;
	}

	/**
	 * Get edible leaf taste profile string.
	 *
	 * @return the string
	 */
	public String getEdibleLeafTasteProfile(){
		return edibleLeafTasteProfile;
	}

	/**
	 * Set flowering season.
	 *
	 * @param floweringSeason the flowering season
	 */
	public void setFloweringSeason(String floweringSeason){
		this.floweringSeason = floweringSeason;
	}

	/**
	 * Get flowering season string.
	 *
	 * @return the string
	 */
	public String getFloweringSeason(){
		return floweringSeason;
	}

	/**
	 * Set origin.
	 *
	 * @param origin the origin
	 */
	public void setOrigin(List<String> origin){
		this.origin = origin;
	}

	/**
	 * Get origin list.
	 *
	 * @return the list
	 */
	public List<String> getOrigin(){
		return origin;
	}

	/**
	 * Set hardiness location image.
	 *
	 * @param hardinessLocationImage the hardiness location image
	 */
	public void setHardinessLocationImage(String hardinessLocationImage){
		this.hardinessLocationImage = hardinessLocationImage;
	}

	/**
	 * Get hardiness location image string.
	 *
	 * @return the string
	 */
	public String getHardinessLocationImage(){
		return hardinessLocationImage;
	}

	/**
	 * Set edible fruit.
	 *
	 * @param edibleFruit the edible fruit
	 */
	public void setEdibleFruit(boolean edibleFruit){
		this.edibleFruit = edibleFruit;
	}

	/**
	 * Is edible fruit boolean.
	 *
	 * @return the boolean
	 */
	public boolean isEdibleFruit(){
		return edibleFruit;
	}

	/**
	 * Set fruit nutritional value.
	 *
	 * @param fruitNutritionalValue the fruit nutritional value
	 */
	public void setFruitNutritionalValue(String fruitNutritionalValue){
		this.fruitNutritionalValue = fruitNutritionalValue;
	}

	/**
	 * Get fruit nutritional value string.
	 *
	 * @return the string
	 */
	public String getFruitNutritionalValue(){
		return fruitNutritionalValue;
	}

	/**
	 * Set description.
	 *
	 * @param description the description
	 */
	public void setDescription(String description){
		this.description = description;
	}

	/**
	 * Get description string.
	 *
	 * @return the string
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * Set soil.
	 *
	 * @param soil the soil
	 */
	public void setSoil(List<Object> soil){
		this.soil = soil;
	}

	/**
	 * Get soil list.
	 *
	 * @return the list
	 */
	public List<Object> getSoil(){
		return soil;
	}

	/**
	 * Set harvest method.
	 *
	 * @param harvestMethod the harvest method
	 */
	public void setHarvestMethod(String harvestMethod){
		this.harvestMethod = harvestMethod;
	}

	/**
	 * Get harvest method string.
	 *
	 * @return the string
	 */
	public String getHarvestMethod(){
		return harvestMethod;
	}

	/**
	 * Set medicinal.
	 *
	 * @param medicinal the medicinal
	 */
	public void setMedicinal(String medicinal){
		this.medicinal = medicinal;
	}

	/**
	 * Get medicinal string.
	 *
	 * @return the string
	 */
	public String getMedicinal(){
		return medicinal;
	}

	/**
	 * Set cycle.
	 *
	 * @param cycle the cycle
	 */
	public void setCycle(String cycle){
		this.cycle = cycle;
	}

	/**
	 * Get cycle string.
	 *
	 * @return the string
	 */
	public String getCycle(){
		return cycle;
	}

	/**
	 * Set fruits.
	 *
	 * @param fruits the fruits
	 */
	public void setFruits(boolean fruits){
		this.fruits = fruits;
	}

	/**
	 * Is fruits boolean.
	 *
	 * @return the boolean
	 */
	public boolean isFruits(){
		return fruits;
	}

	/**
	 * Set poison to pets cure.
	 *
	 * @param poisonToPetsCure the poison to pets cure
	 */
	public void setPoisonToPetsCure(String poisonToPetsCure){
		this.poisonToPetsCure = poisonToPetsCure;
	}

	/**
	 * Get poison to pets cure string.
	 *
	 * @return the string
	 */
	public String getPoisonToPetsCure(){
		return poisonToPetsCure;
	}

	/**
	 * Set rare level.
	 *
	 * @param rareLevel the rare level
	 */
	public void setRareLevel(String rareLevel){
		this.rareLevel = rareLevel;
	}

	/**
	 * Get rare level string.
	 *
	 * @return the string
	 */
	public String getRareLevel(){
		return rareLevel;
	}

	/**
	 * Set dimension.
	 *
	 * @param dimension the dimension
	 */
	public void setDimension(String dimension){
		this.dimension = dimension;
	}

	/**
	 * Get dimension string.
	 *
	 * @return the string
	 */
	public String getDimension(){
		return dimension;
	}

	/**
	 * Set drought tolerant.
	 *
	 * @param droughtTolerant the drought tolerant
	 */
	public void setDroughtTolerant(boolean droughtTolerant){
		this.droughtTolerant = droughtTolerant;
	}

	/**
	 * Is drought tolerant boolean.
	 *
	 * @return the boolean
	 */
	public boolean isDroughtTolerant(){
		return droughtTolerant;
	}

	/**
	 * Set cuisine.
	 *
	 * @param cuisine the cuisine
	 */
	public void setCuisine(boolean cuisine){
		this.cuisine = cuisine;
	}

	/**
	 * Is cuisine boolean.
	 *
	 * @return the boolean
	 */
	public boolean isCuisine(){
		return cuisine;
	}

	/**
	 * Set leaf.
	 *
	 * @param leaf the leaf
	 */
	public void setLeaf(boolean leaf){
		this.leaf = leaf;
	}

	/**
	 * Is leaf boolean.
	 *
	 * @return the boolean
	 */
	public boolean isLeaf(){
		return leaf;
	}

	/**
	 * Set fruiting season.
	 *
	 * @param fruitingSeason the fruiting season
	 */
	public void setFruitingSeason(String fruitingSeason){
		this.fruitingSeason = fruitingSeason;
	}

	/**
	 * Get fruiting season string.
	 *
	 * @return the string
	 */
	public String getFruitingSeason(){
		return fruitingSeason;
	}

	/**
	 * Set hardiness.
	 *
	 * @param hardiness the hardiness
	 */
	public void setHardiness(Hardiness hardiness){
		this.hardiness = hardiness;
	}

	/**
	 * Get hardiness hardiness.
	 *
	 * @return the hardiness
	 */
	public Hardiness getHardiness(){
		return hardiness;
	}

	/**
	 * Set tropical.
	 *
	 * @param tropical the tropical
	 */
	public void setTropical(boolean tropical){
		this.tropical = tropical;
	}

	/**
	 * Is tropical boolean.
	 *
	 * @return the boolean
	 */
	public boolean isTropical(){
		return tropical;
	}

	/**
	 * Set sunlight.
	 *
	 * @param sunlight the sunlight
	 */
	public void setSunlight(List<String> sunlight){
		this.sunlight = sunlight;
	}

	/**
	 * Get sunlight list.
	 *
	 * @return the list
	 */
	public List<String> getSunlight(){
		return sunlight;
	}

	/**
	 * Set watering.
	 *
	 * @param watering the watering
	 */
	public void setWatering(String watering){
		this.watering = watering;
	}

	/**
	 * Get watering string.
	 *
	 * @return the string
	 */
	public String getWatering(){
		return watering;
	}

	/**
	 * Set flower color.
	 *
	 * @param flowerColor the flower color
	 */
	public void setFlowerColor(String flowerColor){
		this.flowerColor = flowerColor;
	}

	/**
	 * Get flower color string.
	 *
	 * @return the string
	 */
	public String getFlowerColor(){
		return flowerColor;
	}

	/**
	 * Set fruit color.
	 *
	 * @param fruitColor the fruit color
	 */
	public void setFruitColor(List<Object> fruitColor){
		this.fruitColor = fruitColor;
	}

	/**
	 * Get fruit color list.
	 *
	 * @return the list
	 */
	public List<Object> getFruitColor(){
		return fruitColor;
	}

	/**
	 * Set medicinal method.
	 *
	 * @param medicinalMethod the medicinal method
	 */
	public void setMedicinalMethod(String medicinalMethod){
		this.medicinalMethod = medicinalMethod;
	}

	/**
	 * Get medicinal method string.
	 *
	 * @return the string
	 */
	public String getMedicinalMethod(){
		return medicinalMethod;
	}

	/**
	 * Set pest susceptibility api.
	 *
	 * @param pestSusceptibilityApi the pest susceptibility api
	 */
	public void setPestSusceptibilityApi(String pestSusceptibilityApi){
		this.pestSusceptibilityApi = pestSusceptibilityApi;
	}

	/**
	 * Get pest susceptibility api string.
	 *
	 * @return the string
	 */
	public String getPestSusceptibilityApi(){
		return pestSusceptibilityApi;
	}

	/**
	 * Set poisonous to pets.
	 *
	 * @param poisonousToPets the poisonous to pets
	 */
	public void setPoisonousToPets(String poisonousToPets){
		this.poisonousToPets = poisonousToPets;
	}

	/**
	 * Get poisonous to pets string.
	 *
	 * @return the string
	 */
	public String getPoisonousToPets(){
		return poisonousToPets;
	}

	/**
	 * Set care level.
	 *
	 * @param careLevel the care level
	 */
	public void setCareLevel(String careLevel){
		this.careLevel = careLevel;
	}

	/**
	 * Get care level string.
	 *
	 * @return the string
	 */
	public String getCareLevel(){
		return careLevel;
	}

	/**
	 * Set other name.
	 *
	 * @param otherName the other name
	 */
	public void setOtherName(List<String> otherName){
		this.otherName = otherName;
	}

	/**
	 * Get other name list.
	 *
	 * @return the list
	 */
	public List<String> getOtherName(){
		return otherName;
	}

	/**
	 * Set edible leaf.
	 *
	 * @param edibleLeaf the edible leaf
	 */
	public void setEdibleLeaf(boolean edibleLeaf){
		this.edibleLeaf = edibleLeaf;
	}

	/**
	 * Is edible leaf boolean.
	 *
	 * @return the boolean
	 */
	public boolean isEdibleLeaf(){
		return edibleLeaf;
	}

	/**
	 * Set family.
	 *
	 * @param family the family
	 */
	public void setFamily(Object family){
		this.family = family;
	}

	/**
	 * Get family object.
	 *
	 * @return the object
	 */
	public Object getFamily(){
		return family;
	}

	/**
	 * Set maintenance.
	 *
	 * @param maintenance the maintenance
	 */
	public void setMaintenance(Object maintenance){
		this.maintenance = maintenance;
	}

	/**
	 * Get maintenance object.
	 *
	 * @return the object
	 */
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