package ca.crystalshard.adapter.web.viewModels;

public class ViewEnvelope {

    public static ViewEnvelope EMPTY = new ViewEnvelope();

    public static ViewEnvelope of(Object results) {
        ViewEnvelope ve = new ViewEnvelope();
        ve.results = results;
        return ve;
    }

    public Object results;
}
