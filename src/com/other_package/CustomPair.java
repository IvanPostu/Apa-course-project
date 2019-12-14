package com.other_package;

/*
* TO DO: OpenJdk 12 has no implementation for Pair class
*
* */
public class CustomPair<F, S> {
  private  F first;
  private  S second;


  public CustomPair(F first, S second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public int hashCode() {
    return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
  }

  public static <A, B> CustomPair<A, B> create(A a, B b) {
    return new CustomPair<A, B>(a, b);
  }


  public F getFirst() {
    return first;
  }

  public S getSecond() {
    return second;
  }

  public void setFirst(F first) {
    this.first = first;
  }

  public void setSecond(S second) {
    this.second = second;
  }
}