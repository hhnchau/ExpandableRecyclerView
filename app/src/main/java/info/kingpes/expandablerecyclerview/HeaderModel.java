package info.kingpes.expandablerecyclerview;

import java.util.List;

public class HeaderModel extends ExpandModel<DetailModel> {
    public HeaderModel(String title, List<DetailModel> details) {
        super(title, details);
    }
}
