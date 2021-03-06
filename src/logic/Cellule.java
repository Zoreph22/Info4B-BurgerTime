package logic;

public class Cellule {
    // Atributs
    private char decor;
    private Entity entity;
    private Morceau morceau;

    // Constructeurs 
    public Cellule(char decor) {
        this.decor = decor;
    }

    public Cellule(Entity entity){
        this.entity = entity;
    } 

    public Cellule(Morceau morceau){
        this.morceau = morceau;
    } 

    // Get
    public char getDecor() {
        return this.decor;
    }

    public Entity getEntity() {
        return this.entity;
    }

    public Morceau getMorceau() {
        return this.morceau;
    }

    // Set
    public void setDecor(char decor) {
        this.decor = decor;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void setMorceau(Morceau morceau) {
        this.morceau = morceau;
    }

    public boolean isBord() {
        return this.decor == '▄' || this.decor == '▀' || this.decor == '▐' || this.decor == '▌';
    }
    
    public boolean isSol() {
        return this.decor == '▬';
    }

    public boolean isAir() {
        return this.decor == ' ';
    }
    
    public boolean isLadder(){
        return this.decor == '▒';
    }
    
    // toString
    public String toString(){
        if(this.entity != null){
            return this.entity.getSymbol();
        }
        if(this.morceau != null){
            return this.morceau.toString();
        }
        return String.valueOf(this.decor);
    }
}
