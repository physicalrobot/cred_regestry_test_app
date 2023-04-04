package com.example.credentialregistrytestapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.credentialregistrytestapp.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

  private FragmentSecondBinding binding;

  String[] item = {"mDoc","password","passkey"};
  AutoCompleteTextView autoCompleteTextView;

  ArrayAdapter<String> adapterItems;


  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
  ) {
    autoCompleteTextView = getView().findViewById(R.id.auto_complete_textview);
    adapterItems = new ArrayAdapter<String>(getActivity(),R.layout.list_item, item);

    autoCompleteTextView.setAdapter(adapterItems);

    autoCompleteTextView.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String item = adapterView.getItemAtPosition(position).toString();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text = "item";

        Toast toast = Toast.makeText( getActivity(),  text + item, duration);
        toast.show();
        ;

      }
    });




    binding = FragmentSecondBinding.inflate(inflater, container, false);
    return binding.getRoot();

  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        NavHostFragment.findNavController(SecondFragment.this)
            .navigate(R.id.action_SecondFragment_to_FirstFragment);
      }
    });
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

}

