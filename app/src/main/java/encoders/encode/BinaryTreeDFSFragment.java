package encoders.encode;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class BinaryTreeDFSFragment extends Fragment {

    Spinner spinner1, spinner2;
    ArrayAdapter<CharSequence> adapter1, adapter2;
    Button go;
    int binary;
    EditText input;
    TextView output;
    String inp;
    String selectedInput, selectedOutput;
    int[] inparr;
    String[] inpstrarr;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.binary_tree_dfs_layout,container,false);
        spinner1 = (Spinner) v.findViewById(R.id.spinner1BTDFS);
        spinner2 = (Spinner) v.findViewById(R.id.spinner2BTDFS);
        adapter1 = ArrayAdapter.createFromResource(getActivity(), R.array.input_mode_names, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.input_mode_names, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        final RelativeLayout mainLayout;
        mainLayout = (RelativeLayout)v.findViewById(R.id.mainLayoutBTDFS);

        input = (EditText) v.findViewById(R.id.inputBTDFS);
        output = (TextView) v.findViewById(R.id.textView4BTDFS);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedInput = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedOutput = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        go = (Button) v.findViewById(R.id.buttonBTDFS);
        go.setOnClickListener(new View.OnClickListener() {
            BinaryTree bt = new BinaryTree();
            //TreeNode root;

            @Override
            public void onClick(View view) {
                inp = input.getText().toString();
                inpstrarr = inp.split(",");
                int len = inpstrarr.length;
                inparr = new int[len];
                for(int i = 0; i<len; i++){
                    inparr[i]=Integer.parseInt(inpstrarr[i]);
                }
                if (selectedInput.equals("Inorder")) {
                    bt.root=bt.constructTreeFromIn(inparr,0,len-1,bt.root);
                }
                else if (selectedInput.equals("Preorder")) {
                    bt.root=bt.constructTreeFromPre(inparr,len);
                }
                else{
                    bt.root=bt.constructTreeFromPost(inparr,len);
                }

                if(selectedOutput.equals("Inorder")) {
                    bt.genInorder(bt.root);
                    String in = bt.inorder.toString();
                    output.setText(in);
                    bt.inorder = new StringBuilder("");
                }
                else if(selectedOutput.equals("Preorder")){
                    bt.genPreorder(bt.root);
                    String pre = bt.preorder.toString();
                    output.setText(pre);
                    bt.preorder = new StringBuilder("");
                }
                else{
                    bt.genPostorder(bt.root);
                    String post = bt.postorder.toString();
                    output.setText(post);
                    bt.postorder = new StringBuilder("");
                }

                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
            }
        });

        return v;
    }
}
