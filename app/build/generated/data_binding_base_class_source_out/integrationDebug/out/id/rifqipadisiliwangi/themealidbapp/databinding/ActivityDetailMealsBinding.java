// Generated by view binder compiler. Do not edit!
package id.rifqipadisiliwangi.themealidbapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import id.rifqipadisiliwangi.themealidbapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDetailMealsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout clMenuData;

  @NonNull
  public final ConstraintLayout clMenuImage;

  @NonNull
  public final CardView cvMenuImage;

  @NonNull
  public final ImageView ivBackHome;

  @NonNull
  public final ImageView ivBookmart;

  @NonNull
  public final ImageView ivStrMealThumb;

  @NonNull
  public final TextView tvIdMeal;

  @NonNull
  public final TextView tvStrArea;

  @NonNull
  public final TextView tvStrCategory;

  @NonNull
  public final TextView tvStrInstructions;

  @NonNull
  public final TextView tvStrMeal;

  @NonNull
  public final YouTubePlayerView youtubePlayerView;

  private ActivityDetailMealsBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout clMenuData, @NonNull ConstraintLayout clMenuImage,
      @NonNull CardView cvMenuImage, @NonNull ImageView ivBackHome, @NonNull ImageView ivBookmart,
      @NonNull ImageView ivStrMealThumb, @NonNull TextView tvIdMeal, @NonNull TextView tvStrArea,
      @NonNull TextView tvStrCategory, @NonNull TextView tvStrInstructions,
      @NonNull TextView tvStrMeal, @NonNull YouTubePlayerView youtubePlayerView) {
    this.rootView = rootView;
    this.clMenuData = clMenuData;
    this.clMenuImage = clMenuImage;
    this.cvMenuImage = cvMenuImage;
    this.ivBackHome = ivBackHome;
    this.ivBookmart = ivBookmart;
    this.ivStrMealThumb = ivStrMealThumb;
    this.tvIdMeal = tvIdMeal;
    this.tvStrArea = tvStrArea;
    this.tvStrCategory = tvStrCategory;
    this.tvStrInstructions = tvStrInstructions;
    this.tvStrMeal = tvStrMeal;
    this.youtubePlayerView = youtubePlayerView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDetailMealsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDetailMealsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_detail_meals, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDetailMealsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cl_menu_data;
      ConstraintLayout clMenuData = ViewBindings.findChildViewById(rootView, id);
      if (clMenuData == null) {
        break missingId;
      }

      id = R.id.cl_menu_image;
      ConstraintLayout clMenuImage = ViewBindings.findChildViewById(rootView, id);
      if (clMenuImage == null) {
        break missingId;
      }

      id = R.id.cv_menu_image;
      CardView cvMenuImage = ViewBindings.findChildViewById(rootView, id);
      if (cvMenuImage == null) {
        break missingId;
      }

      id = R.id.iv_back_home;
      ImageView ivBackHome = ViewBindings.findChildViewById(rootView, id);
      if (ivBackHome == null) {
        break missingId;
      }

      id = R.id.iv_bookmart;
      ImageView ivBookmart = ViewBindings.findChildViewById(rootView, id);
      if (ivBookmart == null) {
        break missingId;
      }

      id = R.id.iv_str_meal_thumb;
      ImageView ivStrMealThumb = ViewBindings.findChildViewById(rootView, id);
      if (ivStrMealThumb == null) {
        break missingId;
      }

      id = R.id.tv_id_meal;
      TextView tvIdMeal = ViewBindings.findChildViewById(rootView, id);
      if (tvIdMeal == null) {
        break missingId;
      }

      id = R.id.tv_str_area;
      TextView tvStrArea = ViewBindings.findChildViewById(rootView, id);
      if (tvStrArea == null) {
        break missingId;
      }

      id = R.id.tv_str_category;
      TextView tvStrCategory = ViewBindings.findChildViewById(rootView, id);
      if (tvStrCategory == null) {
        break missingId;
      }

      id = R.id.tv_str_instructions;
      TextView tvStrInstructions = ViewBindings.findChildViewById(rootView, id);
      if (tvStrInstructions == null) {
        break missingId;
      }

      id = R.id.tv_str_meal;
      TextView tvStrMeal = ViewBindings.findChildViewById(rootView, id);
      if (tvStrMeal == null) {
        break missingId;
      }

      id = R.id.youtube_player_view;
      YouTubePlayerView youtubePlayerView = ViewBindings.findChildViewById(rootView, id);
      if (youtubePlayerView == null) {
        break missingId;
      }

      return new ActivityDetailMealsBinding((ConstraintLayout) rootView, clMenuData, clMenuImage,
          cvMenuImage, ivBackHome, ivBookmart, ivStrMealThumb, tvIdMeal, tvStrArea, tvStrCategory,
          tvStrInstructions, tvStrMeal, youtubePlayerView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
