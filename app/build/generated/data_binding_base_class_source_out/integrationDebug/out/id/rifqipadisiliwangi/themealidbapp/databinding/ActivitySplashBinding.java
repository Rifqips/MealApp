// Generated by view binder compiler. Do not edit!
package id.rifqipadisiliwangi.themealidbapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.rifqipadisiliwangi.themealidbapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySplashBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView ivImgSplash;

  @NonNull
  public final TextView tvCategoriesMeaals;

  private ActivitySplashBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView ivImgSplash,
      @NonNull TextView tvCategoriesMeaals) {
    this.rootView = rootView;
    this.ivImgSplash = ivImgSplash;
    this.tvCategoriesMeaals = tvCategoriesMeaals;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySplashBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySplashBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_splash, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySplashBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_img_splash;
      ImageView ivImgSplash = ViewBindings.findChildViewById(rootView, id);
      if (ivImgSplash == null) {
        break missingId;
      }

      id = R.id.tv_categories_meaals;
      TextView tvCategoriesMeaals = ViewBindings.findChildViewById(rootView, id);
      if (tvCategoriesMeaals == null) {
        break missingId;
      }

      return new ActivitySplashBinding((ConstraintLayout) rootView, ivImgSplash,
          tvCategoriesMeaals);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
