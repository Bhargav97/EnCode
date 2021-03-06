package encoders.encode;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AlgoFragment extends Fragment {
    String options[] = {"Search Algos", "Greedy Algos", "Dynamic Programming Algos"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.algo_fragment,container,false);
        ListView listView = (ListView) v.findViewById(R.id.algo_lv);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_expandable_list_item_1,options);
        listView.setAdapter(arrayAdapter);
        return v;
    }
}
