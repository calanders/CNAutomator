package com.calvinnordstrom.passrepeater.model;

import javafx.beans.property.*;
import java.io.*;

public class RepeatCommand implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private transient StringProperty textBefore;
    private transient StringProperty textAfter;
    private transient ObjectProperty<Direction> direction;
    private transient DoubleProperty initialPos;
    private transient DoubleProperty finalPos;
    private transient DoubleProperty increment;
    private transient StringProperty firstPass;
    private transient StringProperty secondPass;

    private RepeatCommand(Builder builder) {
        textBefore = new SimpleStringProperty(builder.textBefore);
        textAfter = new SimpleStringProperty(builder.textAfter);
        direction = new SimpleObjectProperty<>(builder.direction);
        initialPos = new SimpleDoubleProperty(builder.initialPos);
        finalPos = new SimpleDoubleProperty(builder.finalPos);
        increment = new SimpleDoubleProperty(builder.increment);
        firstPass = new SimpleStringProperty(builder.firstPass);
        secondPass = new SimpleStringProperty(builder.secondPass);
    }

    public String getTextBefore() {
        return textBefore.get();
    }

    public void setTextBefore(String textBefore) {
        this.textBefore.set(textBefore);
    }

    public StringProperty textBeforeProperty() {
        return textBefore;
    }

    public String getTextAfter() {
        return textAfter.get();
    }

    public void setTextAfter(String textAfter) {
        this.textAfter.set(textAfter);
    }

    public StringProperty textAfterProperty() {
        return textAfter;
    }

    public Direction getDirection() {
        return direction.get();
    }

    public void setDirection(Direction direction) {
        this.direction.set(direction);
    }

    public ObjectProperty<Direction> directionProperty() {
        return direction;
    }

    public double getInitialPos() {
        return initialPos.get();
    }

    public void setInitialPos(double initialPos) {
        this.initialPos.set(initialPos);
    }

    public DoubleProperty initialPosProperty() {
        return initialPos;
    }

    public double getFinalPos() {
        return finalPos.get();
    }

    public void setFinalPos(double finalPos) {
        this.finalPos.set(finalPos);
    }

    public DoubleProperty finalPosProperty() {
        return finalPos;
    }

    public double getIncrement() {
        return increment.get();
    }

    public void setIncrement(double increment) {
        this.increment.set(increment);
    }

    public DoubleProperty incrementProperty() {
        return increment;
    }

    public String getFirstPass() {
        return firstPass.get();
    }

    public void setFirstPass(String firstPass) {
        this.firstPass.set(firstPass);
    }

    public StringProperty firstPassProperty() {
        return firstPass;
    }

    public String getSecondPass() {
        return secondPass.get();
    }

    public void setSecondPass(String secondPass) {
        this.secondPass.set(secondPass);
    }

    public StringProperty secondPassProperty() {
        return secondPass;
    }

    public static class Builder {
        private String textBefore;
        private String textAfter;
        private Direction direction;
        private double initialPos;
        private double finalPos;
        private double increment;
        private String firstPass;
        private String secondPass;

        public Builder textBefore(String textBefore) {
            this.textBefore = textBefore;
            return this;
        }

        public Builder textAfter(String textAfter) {
            this.textAfter = textAfter;
            return this;
        }

        public Builder direction(Direction direction) {
            this.direction = direction;
            return this;
        }

        public Builder initialPos(double initialPos) {
            this.initialPos = initialPos;
            return this;
        }

        public Builder finalPos(double finalPos) {
            this.finalPos = finalPos;
            return this;
        }

        public Builder increment(double increment) {
            this.increment = increment;
            return this;
        }

        public Builder firstPass(String firstPass) {
            this.firstPass = firstPass;
            return this;
        }

        public Builder secondPass(String secondPass) {
            this.secondPass = secondPass;
            return this;
        }

        public RepeatCommand build() {
            return new RepeatCommand(this);
        }
    }

    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(textBefore.get());
        out.writeObject(textAfter.get());
        out.writeObject(direction.get());
        out.writeDouble(initialPos.get());
        out.writeDouble(finalPos.get());
        out.writeDouble(increment.get());
        out.writeObject(firstPass.get());
        out.writeObject(secondPass.get());
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        textBefore = new SimpleStringProperty((String) in.readObject());
        textAfter = new SimpleStringProperty((String) in.readObject());
        direction = new SimpleObjectProperty<>((Direction) in.readObject());
        initialPos = new SimpleDoubleProperty(in.readDouble());
        finalPos = new SimpleDoubleProperty(in.readDouble());
        increment = new SimpleDoubleProperty(in.readDouble());
        firstPass = new SimpleStringProperty((String) in.readObject());
        secondPass = new SimpleStringProperty((String) in.readObject());
    }
}
