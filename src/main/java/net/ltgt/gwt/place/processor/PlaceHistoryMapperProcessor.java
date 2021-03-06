package net.ltgt.gwt.place.processor;

import java.util.Arrays;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.Processor;
import javax.lang.model.SourceVersion;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.auto.service.AutoService;
import com.google.common.collect.ImmutableList;

@AutoService(Processor.class)
public class PlaceHistoryMapperProcessor extends BasicAnnotationProcessor {
  @Override
  public SourceVersion getSupportedSourceVersion() {
    return SourceVersion.latestSupported();
  }

  @Override
  protected Iterable<? extends ProcessingStep> initSteps() {
    Messager messager = processingEnv.getMessager();
    Filer filer = processingEnv.getFiler();
    Types types = processingEnv.getTypeUtils();
    Elements elements = processingEnv.getElementUtils();
    return ImmutableList.of(
        new PrefixProcessingStep(messager, types, elements),
        new PlaceHistoryMapperProcessingStep(messager, filer, types, elements)
    );
  }
}
