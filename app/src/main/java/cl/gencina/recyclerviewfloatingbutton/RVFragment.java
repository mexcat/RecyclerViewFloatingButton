package cl.gencina.recyclerviewfloatingbutton;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cl.gencina.recyclerviewfloatingbutton.databinding.FragmentRVBinding;

public class RVFragment extends Fragment {
    FragmentRVBinding binding;
    List<String> data = new ArrayList<String>();
    RvAdapter infoAdapter = new RvAdapter();

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public RVFragment() {
        // Required empty public constructor
    }

    public static RVFragment newInstance(String param1, String param2) {
        RVFragment fragment = new RVFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRVBinding.inflate(getActivity().getLayoutInflater(), container, false);
        setRvAdapter();
        binding.fabAdd.setOnClickListener(v -> {
            addData();
        });
        return binding.getRoot();
    }
    public void setRvAdapter(){
        infoAdapter.setInfo(createData());
        binding.rvLista.setAdapter(infoAdapter);
    }

    public List<String> createData(){
        for(int i=0; i< 20; i++){
            data.add("Data "+ String.valueOf(i));
        }
        return data;
    }

    public void addData(){
        data.add("Data "+ String.valueOf(data.size()));
        this.infoAdapter.setInfo(data);
        this.infoAdapter.notifyDataSetChanged();
    }

}