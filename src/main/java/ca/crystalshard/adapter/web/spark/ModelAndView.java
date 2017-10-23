package ca.crystalshard.adapter.web.spark;

public class ModelAndView extends spark.ModelAndView {

    public ModelAndView(Object model, String viewName) {
        super(model, "views/" + viewName);
    }
}
