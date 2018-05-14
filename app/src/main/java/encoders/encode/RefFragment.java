package encoders.encode;

import android.app.Activity;
import android.content.Intent;
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

public class RefFragment extends Fragment {

    String options[] = {"ASCII", "Unicode", "Number System"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.ref_fragment,container,false);
        ListView listView = (ListView) v.findViewById(R.id.ref_lv);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1,options);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View v, int position, long id){
                String selectedItem = (String) parent.getItemAtPosition(position);

                if(selectedItem.equals("ASCII")){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AsciiFragment()).addToBackStack(null).commit();
                }
                else if(selectedItem.equals("Unicode")){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new UnicodeFragment()).addToBackStack(null).commit();
                }
                else {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new NumberSystemFragment()).addToBackStack(null).commit();

                }
                /*Intent intent = new Intent(Activity.this,destinationActivity.class);
                //based on item add info to intent
                startActivity(intent);*/
            }
        });
        return v;
    }
}
