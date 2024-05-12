public class StopWord {
    ////////////////////////////// ATTRIBUTES //////////////////////////////
    private final String stopWord;
    private final String stopWordRomanian;
    private final String stopWordSentence;
    private final String stopWordSentenceRomanian;
    ////////////////////////////// ATTRIBUTES //////////////////////////////

    ////////////////////////////// CONSTRUCTOR //////////////////////////////
    public StopWord(String stopWord, String stopWordRomanian, String stopWordSentence,
                    String stopWordSentenceRomanian) {
        this.stopWord = stopWord;
        this.stopWordRomanian = stopWordRomanian;
        this.stopWordSentence = stopWordSentence;
        this.stopWordSentenceRomanian = stopWordSentenceRomanian;
    }
    ////////////////////////////// CONSTRUCTOR //////////////////////////////

    ////////////////////////////// GETTERS //////////////////////////////
    public String getStopWord() {
        return stopWord;
    }
    public String getStopWordRomanian() {
        return stopWordRomanian;
    }
    public String getStopWordSentence() {
        return stopWordSentence;
    }
    public String getStopWordSentenceRomanian() {
        return stopWordSentenceRomanian;
    }
    ////////////////////////////// GETTERS //////////////////////////////
}
