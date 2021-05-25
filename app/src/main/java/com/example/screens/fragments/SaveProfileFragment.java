package com.example.screens.fragments;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.screens.MainActivity;
import com.example.screens.R;
import com.example.screens.adapters.MyListAdapter;
import com.example.screens.adapters.ParentAdapter;
import com.github.dhaval2404.imagepicker.ImagePicker;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SaveProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SaveProfileFragment extends Fragment implements View.OnClickListener {

    RecyclerView recyclerView;
    ParentAdapter parentAdapter;
    ImageView editBtn;
    CircleImageView circleImageView;
    TextView dateTV;
    TextView genderTV;
    private int mYear, mMonth, mDay, mHour, mMinute;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SaveProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SaveProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SaveProfileFragment newInstance(String param1, String param2) {
        SaveProfileFragment fragment = new SaveProfileFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_save_profile, container, false);

        initComponent(view);
        setListener();
        setAdapter(view);

        return view;
    }

    private void setListener() {
        editBtn.setOnClickListener(this);
        dateTV.setOnClickListener(this);
        genderTV.setOnClickListener(this);
    }

    private void setAdapter(View view) {
        parentAdapter = new ParentAdapter(getActivity());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(parentAdapter);
    }

    private void initComponent(View view) {
        recyclerView = view.findViewById(R.id.fragment_save_profile_recycler_view);
        editBtn = view.findViewById(R.id.edit_Btn);
        circleImageView = view.findViewById(R.id.image_CI);
        dateTV = view.findViewById(R.id.dateTV);
        genderTV = view.findViewById(R.id.genderTV);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_Btn: {
                selectImage();
                break;
            }
            case R.id.dateTV: {
                getDate();
                break;
            }
            case R.id.genderTV: {
                Toast.makeText(getActivity(), "this", Toast.LENGTH_SHORT).show();
                getGender();
                break;
            }
        }
    }

    private void getGender() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Select your gender");
        String[] items = {"Male","Female","Non-Binary","Prefer not to say"};
        int checkedItem = 1;
        alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
        });
        AlertDialog alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }

    private void getDate() {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        dateTV.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }


    private void selectImage() {
        ImagePicker.Companion.with(this)
                .crop(16f, 16f)                    //Crop image(Optional), Check Customization for more option
                .compress(1024)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(256, 256)    //Final image resolution will be less than 1080 x 1080(Optional)
                .start();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            Uri fileUri = data.getData();
            circleImageView.setImageURI(fileUri);
        }
    }
}