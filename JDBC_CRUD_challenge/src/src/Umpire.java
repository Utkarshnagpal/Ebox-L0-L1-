package src;


public class Umpire {
    private Long umpireId;
    private String umpireName;

    public Umpire(Long umpireId, String umpireName) {
        this.umpireId = umpireId;
        this.umpireName = umpireName;
    }

    public Long getUmpireId() {
        return umpireId;
    }

    public void setUmpireId(Long umpireId) {
        this.umpireId = umpireId;
    }

    public String getUmpireName() {
        return umpireName;
    }

    public void setUmpireName(String umpireName) {
        this.umpireName = umpireName;
    }
   
    
    @Override
    public String toString() {
        return  umpireName;
    }
    

}

