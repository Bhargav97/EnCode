package encoders.encode;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DSFragment extends Fragment {
    String options[] = {"Binary Tree", "n-ary Tree", "Directed Graph", "Undirected Graph", "DAG"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.ds_fragment,container,false);
        ListView listView = (ListView) v.findViewById(R.id.ds_lv);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_expandable_list_item_1,options);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View v, int position, long id){
                String selectedItem = (String) parent.getItemAtPosition(position);

                if(selectedItem.equals("Binary Tree")){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BinaryTreeFragment()).addToBackStack(null).commit();
                }
                else if(selectedItem.equals("n-ary Tree")){
                    //todo
                }
                else if(selectedItem.equals("Directed Graph")){
                    //todo
                }
                else if(selectedItem.equals("Undirected Graph")){
                    //todo
                }
                else {
                    //todo
                }
                /*Intent intent = new Intent(Activity.this,destinationActivity.class);
                //based on item add info to intent
                startActivity(intent);*/
            }
        });
        return v;
    }

}
