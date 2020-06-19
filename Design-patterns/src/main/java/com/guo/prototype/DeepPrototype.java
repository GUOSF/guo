package com.guo.prototype;

import lombok.Data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gsf
 * @date 2020/6/14 19:08
 */
@Data
public class DeepPrototype implements Cloneable, Serializable {

    private Integer age;
    private String name;
    private List<String> hobbies;

    @Override
    public DeepPrototype clone() {
        try {
            return (DeepPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public DeepPrototype deepCloneHobbies() {
        try {
            DeepPrototype result = (DeepPrototype) super.clone();
            result.hobbies = (List) ((ArrayList) result.hobbies).clone();
            return result;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public DeepPrototype deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            return (DeepPrototype) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
