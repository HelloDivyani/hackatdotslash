package com.clarifai.android.starter.api.v2.adapter;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import clarifai2.dto.prediction.Concept;
import com.clarifai.android.starter.api.v2.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RecognizeConceptsAdapter extends RecyclerView.Adapter<RecognizeConceptsAdapter.Holder> {

  @NonNull private List<Concept> concepts = new ArrayList<>();
  String s = "";
  Context context;


  public RecognizeConceptsAdapter setData(@NonNull List<Concept> concepts, Context context) {
    this.concepts = concepts;
    this.context = context;
    notifyDataSetChanged();

    return this;
  }

  @Override public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_concept, parent, false));
  }

  @Override public void onBindViewHolder(Holder holder, int position) {
    final Concept concept = concepts.get(position);
    holder.label.setText(concept.name() != null ? concept.name() : concept.id());
    s = s + " "+ holder.label.getText().toString();


    holder.probability.setText(String.valueOf(concept.value()));
  }

  @Override public int getItemCount() {
    return concepts.size();
  }

  static final class Holder extends RecyclerView.ViewHolder {

    @BindView(R.id.label) TextView label;
    @BindView(R.id.probability) TextView probability;

    public Holder(View root) {
      super(root);
      ButterKnife.bind(this, root);
    }
  }
}
