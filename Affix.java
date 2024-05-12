public class Affix {
    ////////////////////////////// ATTRIBUTES //////////////////////////////
    private final String affix;
    private final String type;
    private final String exampleLemma;
    private final String exampleLemmaRomanian;
    private final String exampleWithAffix;
    private final String exampleWithAffixRomanian;
    private final String morphologicalProcess;
    private final String exampleExplanation;
    ////////////////////////////// ATTRIBUTES //////////////////////////////

    ////////////////////////////// CONSTRUCTOR //////////////////////////////
    public Affix(String affix, String type, String exampleLemma, String exampleLemmaRomanian,
                 String exampleWithAffix, String exampleWithAffixRomanian, String morphologicalProcess,
                 String exampleExplanation) {
        this.affix = affix;
        this.type = type;
        this.exampleLemma = exampleLemma;
        this.exampleLemmaRomanian = exampleLemmaRomanian;
        this.exampleWithAffix = exampleWithAffix;
        this.exampleWithAffixRomanian = exampleWithAffixRomanian;
        this.morphologicalProcess = morphologicalProcess;
        this.exampleExplanation = exampleExplanation;
    }
    ////////////////////////////// CONSTRUCTOR //////////////////////////////

    ////////////////////////////// GETTERS //////////////////////////////
    public String getAffix() {
        return affix;
    }
    public String getType() {
        return type;
    }
    public String getExampleLemma() {
        return exampleLemma;
    }
    public String getExampleLemmaRomanian() {
        return exampleLemmaRomanian;
    }
    public String getExampleWithAffix() {
        return exampleWithAffix;
    }
    public String getExampleWithAffixRomanian() {
        return exampleWithAffixRomanian;
    }
    public String getMorphologicalProcess() {
        return morphologicalProcess;
    }
    public String getExampleExplanation() {
        return exampleExplanation;
    }
    ////////////////////////////// GETTERS //////////////////////////////
}
