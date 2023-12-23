// Generated by view binder compiler. Do not edit!
package id.rifqipadisiliwangi.themealidbapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import id.rifqipadisiliwangi.themealidbapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDashboardBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout clAreasMeaals;

  @NonNull
  public final ConstraintLayout clCategoriesMeaals;

  @NonNull
  public final ConstraintLayout clRecommended;

  @NonNull
  public final ConstraintLayout clSearchMeaals;

  @NonNull
  public final EditText etSearch;

  @NonNull
  public final FloatingActionButton fabBookmark;

  @NonNull
  public final ImageView ivSeachMealsName;

  @NonNull
  public final ImageView ivSwitchGrid;

  @NonNull
  public final ImageView ivSwitchList;

  @NonNull
  public final CommonLayoutContentStateBinding layoutStateAreasMeals;

  @NonNull
  public final CommonLayoutContentStateBinding layoutStateCategoriesMeals;

  @NonNull
  public final CommonLayoutContentStateBinding layoutStateMenu;

  @NonNull
  public final CommonLayoutContentStateBinding layoutStateMenuSearch;

  @NonNull
  public final RecyclerView rvAreasMeaals;

  @NonNull
  public final RecyclerView rvCategoriesMeaals;

  @NonNull
  public final RecyclerView rvMealsList;

  @NonNull
  public final RecyclerView rvSearchMeaals;

  @NonNull
  public final RelativeLayout searchMeals;

  @NonNull
  public final TextView tvAreasMeaals;

  @NonNull
  public final TextView tvCategoriesMeaals;

  @NonNull
  public final TextView tvFilterAreasMeaals;

  @NonNull
  public final TextView tvFilterCategoriesMeaals;

  @NonNull
  public final TextView tvFilterLetterMeaals;

  @NonNull
  public final TextView tvRecommended;

  private ActivityDashboardBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout clAreasMeaals, @NonNull ConstraintLayout clCategoriesMeaals,
      @NonNull ConstraintLayout clRecommended, @NonNull ConstraintLayout clSearchMeaals,
      @NonNull EditText etSearch, @NonNull FloatingActionButton fabBookmark,
      @NonNull ImageView ivSeachMealsName, @NonNull ImageView ivSwitchGrid,
      @NonNull ImageView ivSwitchList,
      @NonNull CommonLayoutContentStateBinding layoutStateAreasMeals,
      @NonNull CommonLayoutContentStateBinding layoutStateCategoriesMeals,
      @NonNull CommonLayoutContentStateBinding layoutStateMenu,
      @NonNull CommonLayoutContentStateBinding layoutStateMenuSearch,
      @NonNull RecyclerView rvAreasMeaals, @NonNull RecyclerView rvCategoriesMeaals,
      @NonNull RecyclerView rvMealsList, @NonNull RecyclerView rvSearchMeaals,
      @NonNull RelativeLayout searchMeals, @NonNull TextView tvAreasMeaals,
      @NonNull TextView tvCategoriesMeaals, @NonNull TextView tvFilterAreasMeaals,
      @NonNull TextView tvFilterCategoriesMeaals, @NonNull TextView tvFilterLetterMeaals,
      @NonNull TextView tvRecommended) {
    this.rootView = rootView;
    this.clAreasMeaals = clAreasMeaals;
    this.clCategoriesMeaals = clCategoriesMeaals;
    this.clRecommended = clRecommended;
    this.clSearchMeaals = clSearchMeaals;
    this.etSearch = etSearch;
    this.fabBookmark = fabBookmark;
    this.ivSeachMealsName = ivSeachMealsName;
    this.ivSwitchGrid = ivSwitchGrid;
    this.ivSwitchList = ivSwitchList;
    this.layoutStateAreasMeals = layoutStateAreasMeals;
    this.layoutStateCategoriesMeals = layoutStateCategoriesMeals;
    this.layoutStateMenu = layoutStateMenu;
    this.layoutStateMenuSearch = layoutStateMenuSearch;
    this.rvAreasMeaals = rvAreasMeaals;
    this.rvCategoriesMeaals = rvCategoriesMeaals;
    this.rvMealsList = rvMealsList;
    this.rvSearchMeaals = rvSearchMeaals;
    this.searchMeals = searchMeals;
    this.tvAreasMeaals = tvAreasMeaals;
    this.tvCategoriesMeaals = tvCategoriesMeaals;
    this.tvFilterAreasMeaals = tvFilterAreasMeaals;
    this.tvFilterCategoriesMeaals = tvFilterCategoriesMeaals;
    this.tvFilterLetterMeaals = tvFilterLetterMeaals;
    this.tvRecommended = tvRecommended;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDashboardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDashboardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_dashboard, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDashboardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cl_areas_meaals;
      ConstraintLayout clAreasMeaals = ViewBindings.findChildViewById(rootView, id);
      if (clAreasMeaals == null) {
        break missingId;
      }

      id = R.id.cl_categories_meaals;
      ConstraintLayout clCategoriesMeaals = ViewBindings.findChildViewById(rootView, id);
      if (clCategoriesMeaals == null) {
        break missingId;
      }

      id = R.id.cl_recommended;
      ConstraintLayout clRecommended = ViewBindings.findChildViewById(rootView, id);
      if (clRecommended == null) {
        break missingId;
      }

      id = R.id.cl_search_meaals;
      ConstraintLayout clSearchMeaals = ViewBindings.findChildViewById(rootView, id);
      if (clSearchMeaals == null) {
        break missingId;
      }

      id = R.id.et_search;
      EditText etSearch = ViewBindings.findChildViewById(rootView, id);
      if (etSearch == null) {
        break missingId;
      }

      id = R.id.fab_bookmark;
      FloatingActionButton fabBookmark = ViewBindings.findChildViewById(rootView, id);
      if (fabBookmark == null) {
        break missingId;
      }

      id = R.id.iv_seach_meals_name;
      ImageView ivSeachMealsName = ViewBindings.findChildViewById(rootView, id);
      if (ivSeachMealsName == null) {
        break missingId;
      }

      id = R.id.iv_switch_grid;
      ImageView ivSwitchGrid = ViewBindings.findChildViewById(rootView, id);
      if (ivSwitchGrid == null) {
        break missingId;
      }

      id = R.id.iv_switch_list;
      ImageView ivSwitchList = ViewBindings.findChildViewById(rootView, id);
      if (ivSwitchList == null) {
        break missingId;
      }

      id = R.id.layout_state_areas_meals;
      View layoutStateAreasMeals = ViewBindings.findChildViewById(rootView, id);
      if (layoutStateAreasMeals == null) {
        break missingId;
      }
      CommonLayoutContentStateBinding binding_layoutStateAreasMeals = CommonLayoutContentStateBinding.bind(layoutStateAreasMeals);

      id = R.id.layout_state_categories_meals;
      View layoutStateCategoriesMeals = ViewBindings.findChildViewById(rootView, id);
      if (layoutStateCategoriesMeals == null) {
        break missingId;
      }
      CommonLayoutContentStateBinding binding_layoutStateCategoriesMeals = CommonLayoutContentStateBinding.bind(layoutStateCategoriesMeals);

      id = R.id.layout_state_menu;
      View layoutStateMenu = ViewBindings.findChildViewById(rootView, id);
      if (layoutStateMenu == null) {
        break missingId;
      }
      CommonLayoutContentStateBinding binding_layoutStateMenu = CommonLayoutContentStateBinding.bind(layoutStateMenu);

      id = R.id.layout_state_menu_search;
      View layoutStateMenuSearch = ViewBindings.findChildViewById(rootView, id);
      if (layoutStateMenuSearch == null) {
        break missingId;
      }
      CommonLayoutContentStateBinding binding_layoutStateMenuSearch = CommonLayoutContentStateBinding.bind(layoutStateMenuSearch);

      id = R.id.rv_areas_meaals;
      RecyclerView rvAreasMeaals = ViewBindings.findChildViewById(rootView, id);
      if (rvAreasMeaals == null) {
        break missingId;
      }

      id = R.id.rv_categories_meaals;
      RecyclerView rvCategoriesMeaals = ViewBindings.findChildViewById(rootView, id);
      if (rvCategoriesMeaals == null) {
        break missingId;
      }

      id = R.id.rv_meals_list;
      RecyclerView rvMealsList = ViewBindings.findChildViewById(rootView, id);
      if (rvMealsList == null) {
        break missingId;
      }

      id = R.id.rv_search_meaals;
      RecyclerView rvSearchMeaals = ViewBindings.findChildViewById(rootView, id);
      if (rvSearchMeaals == null) {
        break missingId;
      }

      id = R.id.search_meals;
      RelativeLayout searchMeals = ViewBindings.findChildViewById(rootView, id);
      if (searchMeals == null) {
        break missingId;
      }

      id = R.id.tv_areas_meaals;
      TextView tvAreasMeaals = ViewBindings.findChildViewById(rootView, id);
      if (tvAreasMeaals == null) {
        break missingId;
      }

      id = R.id.tv_categories_meaals;
      TextView tvCategoriesMeaals = ViewBindings.findChildViewById(rootView, id);
      if (tvCategoriesMeaals == null) {
        break missingId;
      }

      id = R.id.tv_filter_areas_meaals;
      TextView tvFilterAreasMeaals = ViewBindings.findChildViewById(rootView, id);
      if (tvFilterAreasMeaals == null) {
        break missingId;
      }

      id = R.id.tv_filter_categories_meaals;
      TextView tvFilterCategoriesMeaals = ViewBindings.findChildViewById(rootView, id);
      if (tvFilterCategoriesMeaals == null) {
        break missingId;
      }

      id = R.id.tv_filter_letter_meaals;
      TextView tvFilterLetterMeaals = ViewBindings.findChildViewById(rootView, id);
      if (tvFilterLetterMeaals == null) {
        break missingId;
      }

      id = R.id.tv_recommended;
      TextView tvRecommended = ViewBindings.findChildViewById(rootView, id);
      if (tvRecommended == null) {
        break missingId;
      }

      return new ActivityDashboardBinding((ConstraintLayout) rootView, clAreasMeaals,
          clCategoriesMeaals, clRecommended, clSearchMeaals, etSearch, fabBookmark,
          ivSeachMealsName, ivSwitchGrid, ivSwitchList, binding_layoutStateAreasMeals,
          binding_layoutStateCategoriesMeals, binding_layoutStateMenu,
          binding_layoutStateMenuSearch, rvAreasMeaals, rvCategoriesMeaals, rvMealsList,
          rvSearchMeaals, searchMeals, tvAreasMeaals, tvCategoriesMeaals, tvFilterAreasMeaals,
          tvFilterCategoriesMeaals, tvFilterLetterMeaals, tvRecommended);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}