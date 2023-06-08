public class TestJson {

    static private long total = 0;
    private long mid=1;
    private String name;
    private float weight;
    private float height;
    private String category;
    private float overall_ability;

    public TestJson( String name, float height, float weight, String category, float overall_ability ) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.category=category;
        this.overall_ability=overall_ability;
        total++;
        this.mid = total;
    }

    public long getId() {
        return mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {return weight;}

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {return height;}

    public void setHeight(float height) {
        this.height = height;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getOverall_ability() {return overall_ability;}

    public void setOverall_ability(float overall_ability) {
        this.overall_ability = overall_ability;
    }


}


