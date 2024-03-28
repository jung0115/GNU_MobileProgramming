// Generated by view binder compiler. Do not edit!
package jmi.gnu.week04_1.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import jmi.gnu.week04_1.R;

public final class ActivityAnimalBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnCheck;

  @NonNull
  public final CheckBox checkbox;

  @NonNull
  public final ImageView imgAnimal;

  @NonNull
  public final RadioButton radioCat;

  @NonNull
  public final RadioButton radioDog;

  @NonNull
  public final RadioGroup radioGroup;

  @NonNull
  public final RadioButton radioRabbit;

  @NonNull
  public final TextView textAnimal;

  private ActivityAnimalBinding(@NonNull LinearLayout rootView, @NonNull Button btnCheck,
      @NonNull CheckBox checkbox, @NonNull ImageView imgAnimal, @NonNull RadioButton radioCat,
      @NonNull RadioButton radioDog, @NonNull RadioGroup radioGroup,
      @NonNull RadioButton radioRabbit, @NonNull TextView textAnimal) {
    this.rootView = rootView;
    this.btnCheck = btnCheck;
    this.checkbox = checkbox;
    this.imgAnimal = imgAnimal;
    this.radioCat = radioCat;
    this.radioDog = radioDog;
    this.radioGroup = radioGroup;
    this.radioRabbit = radioRabbit;
    this.textAnimal = textAnimal;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAnimalBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAnimalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_animal, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAnimalBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_check;
      Button btnCheck = ViewBindings.findChildViewById(rootView, id);
      if (btnCheck == null) {
        break missingId;
      }

      id = R.id.checkbox;
      CheckBox checkbox = ViewBindings.findChildViewById(rootView, id);
      if (checkbox == null) {
        break missingId;
      }

      id = R.id.img_animal;
      ImageView imgAnimal = ViewBindings.findChildViewById(rootView, id);
      if (imgAnimal == null) {
        break missingId;
      }

      id = R.id.radio_cat;
      RadioButton radioCat = ViewBindings.findChildViewById(rootView, id);
      if (radioCat == null) {
        break missingId;
      }

      id = R.id.radio_dog;
      RadioButton radioDog = ViewBindings.findChildViewById(rootView, id);
      if (radioDog == null) {
        break missingId;
      }

      id = R.id.radio_group;
      RadioGroup radioGroup = ViewBindings.findChildViewById(rootView, id);
      if (radioGroup == null) {
        break missingId;
      }

      id = R.id.radio_rabbit;
      RadioButton radioRabbit = ViewBindings.findChildViewById(rootView, id);
      if (radioRabbit == null) {
        break missingId;
      }

      id = R.id.text_animal;
      TextView textAnimal = ViewBindings.findChildViewById(rootView, id);
      if (textAnimal == null) {
        break missingId;
      }

      return new ActivityAnimalBinding((LinearLayout) rootView, btnCheck, checkbox, imgAnimal,
          radioCat, radioDog, radioGroup, radioRabbit, textAnimal);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}