//package sort.parse;
//
//import java.io.UnsupportedEncodingException;
//import java.lang.reflect.Field;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Iterator;
//import java.util.List;
//
//
///**
// * Created by Administrator on 2015-12-17 0017. email: github888888@163.com
// */
//public class ParseFactory {
//    private static ParseFactory sInstance = new ParseFactory();
//    
//    private ParseFactory() {
//    }
//
//    public static ParseFactory getInstance() {
//        return sInstance;
//    }
//
//    public static void main(String[] args) {
//        Person p = new Person();
//        p.age = 6;
//        p.name = "abc";
//        System.out.println(Integer.toBinaryString(p.age));
//        byte[] bean2byte = ParseFactory.getInstance().bean2byte(p, new ArrayList<Position>(), true);
//        
//        System.out.println(Arrays.toString(bean2byte));
//        
//        Person p2 = ParseFactory.getInstance().byte2bean(bean2byte, Person.class, new P());
//        System.out.println(p2.toString());
//    }
//    
//    public static class Person {
//        @Order(1)
//        public int age;
//        @Order(2)
//        public String name;
//        @Override
//        public String toString() {
//            return "Person [age=" + age + ", name=" + name + "]";
//        }
//    }
//    public <T> T byte2bean(byte[] buff, Class<T> beanClass, P p) {
//        try {
//            T t = beanClass.newInstance();
//            List<Field> fildlist = getFieldList(beanClass);
//            if (null == fildlist || fildlist.size() == 0)
//                return t;
//            Collections.sort(fildlist, new Comparator<Field>() {
//                public int compare(Field lhs, Field rhs) {
//                    return lhs.getAnnotation(Order.class).value()
//                            - rhs.getAnnotation(Order.class).value();
//                }
//            });
//            for (Field item1 : fildlist) {
//                item1.setAccessible(true);
//                Type genericType = item1.getGenericType();
//                Class<?> type1 = item1.getType();
//                if (type1.isPrimitive()) {
//                    generateObject(buff, item1, p, t);
//                } else if (type1 == String.class) {
//                    generateObject(buff, item1, p, t);
//                } else if (genericType instanceof ParameterizedType) {
//                    ParameterizedType type = (ParameterizedType) genericType;
//                    Type[] actualTypeArguments = type.getActualTypeArguments();
//                    if (type1 == List.class) { 
//                        int i = byte2int(buff, p.x);
//                        p.x = p.x + 4;
//                        List<Object> list = new ArrayList<Object>();
//                        item1.set(t, list);
//                        for (int j = 0; j < i; j++) {
//                            list.add(byte2bean(buff,
//                                    (Class<?>) actualTypeArguments[0], p));
//                        }
//                    }
//                } else {
//                    try {
//                        // �?后执�?
//                        Field f = type1.getDeclaredField("TYPE");
//                        if (f != null && ((Class<?>) f.get(null)).isPrimitive()) {
//                            generateObject(buff, item1, p, t);
//                        }
//                    } catch (Exception e) {
//                        // 不是基本包装类型
//                        item1.set(t, byte2bean(buff, type1, p));
//                    }
//                }
//            }
//            return t;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static class P {
//        public int x;
//
//        public P(int i) {
//            this.x = i;
//        }
//
//        public P() {
//
//        }
//    }
//
//    private <T> void generateObject(byte[] buff, Field item1, P p, T t) {
//        try {
//            Class<?> type = item1.getType();
//            if (type == byte.class || type == Byte.class) {
//                byte i = byteArray2byte(buff, p.x);
//                p.x += 1;
//                item1.set(t, i);
//            } else if (type == char.class) {
//                char i = byte2char(buff, p.x);
//                p.x += 2;
//                item1.set(t, i);
//            } else if (type == short.class) {
//                short i = byte2short(buff, p.x);
//                p.x += 2;
//                item1.set(t, i);
//            } else if (type == int.class) {
//                int i = byte2int(buff, p.x);
//                p.x = p.x + 4;
//                item1.set(t, i);
//            } else if (type == float.class) {
//                float i = byte2float(buff, p.x);
//                p.x += 4;
//                item1.set(t, i);
//            } else if (type == long.class) {
//                long i = byte2long(buff, p.x);
//                p.x += 8;
//                item1.set(t, i);
//            } else if (type == double.class) {
//                double i = byte2double(buff, p.x);
//                p.x += 8;
//                item1.set(t, i);
//            } else if (type == String.class) {
//                int i = byte2int(buff, p.x);
//                p.x += 4;
//                String str = byte2String(buff, p.x, i);
//                p.x += i;
//                item1.set(t, str);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public <K> byte[] bean2byte(K t, List<Position> list, boolean join) {
//        List<Field> fildlist = getFieldList(t.getClass());
//        if (null == fildlist || fildlist.size() == 0)
//            return null;
//        Collections.sort(fildlist, new Comparator<Field>() {
//            public int compare(Field lhs, Field rhs) {
//                return lhs.getAnnotation(Order.class).value()
//                        - rhs.getAnnotation(Order.class).value();
//            }
//        });
//        for (Field item : fildlist) {
//            Type genericType = item.getGenericType();
//            Class<?> type1 = item.getType();
//            try {
//                if (item.getType().isPrimitive()) {
//                    generatePosition(t, item, list);
//                } else if (type1 == String.class) {
//                    generatePosition(t, item, list);
//                } else if (genericType instanceof ParameterizedType) {
//                    if (type1 == List.class) {
//                        List<?> olist = (List<?>) item.get(t);
//                        Position p = getnewPosition(list);
//                        p.len = 4;
//                        p.buff = int2byte(olist.size());
//                        list.add(p);
//                        for (Object x : olist) {
//                            bean2byte(x, list, false);
//                        }
//                    }
//                } else {
//                    try {
//                        // �?后处理包装类
//                        Field f = type1.getDeclaredField("TYPE");
//                        if (f != null && ((Class<?>) f.get(null)).isPrimitive()) {
//                            generatePosition(t, item, list);
//                        }
//                    } catch (Exception e) {
//                        // 不是基本包装类型
//                        Object o = item.get(t);
//                        bean2byte(o, list, false);
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        if (join) {
//            Position p = getnewPosition(list);
//            byte[] buff = new byte[p.start + p.len];
//            for (Position item : list) {
//                System.arraycopy(item.buff, 0, buff, item.start, item.len);
//            }
//            return buff;
//        } else {
//            return null;
//        }
//    }
//
//    private Position getnewPosition(List<Position> list) {
//        Position lastposition;
//        if (0 != list.size()) {
//            lastposition = list.get(list.size() - 1);
//        } else {
//            lastposition = new Position();
//        }
//
//        final Position p = new Position();
//        p.start = lastposition.start + lastposition.len;
//        return p;
//    }
//
//    private <T> void generatePosition(T t, Field item, List<Position> list) {
//        final Position p = getnewPosition(list);
//        try {
//            Object o = item.get(t);
//            Class<?> type = item.getType();
//            if (type == byte.class || type == Byte.class) {
//                p.len = 1;
//                p.buff = byte2byteArray((Byte) o);
//                list.add(p);
//            } else if (type == char.class || type == Character.class) {
//                p.len = 2;
//                p.buff = char2byte((Character) o);
//                list.add(p);
//            } else if (type == short.class || type == Short.class) {
//                p.len = 2;
//                p.buff = short2byte((Short) o);
//                list.add(p);
//            } else if (type == int.class || type == Integer.class) {
//                p.len = 4;
//                p.buff = int2byte((Integer) o);
//                list.add(p);
//            } else if (type == float.class || type == Float.class ) {
//                p.len = 4;
//                p.buff = float2byte((Float) o);
//                list.add(p);
//            } else if (type == double.class || type == Double.class) {
//                p.len = 8;
//                p.buff = double2byte((Double) o);
//                list.add(p);
//            } else if (type == long.class || type == Long.class) {
//                p.len = 8;
//                p.buff = long2byte((Long) o);
//                list.add(p);
//            } else if (type == String.class) {
//                String s;
//                if(null == o || o.equals("")) {
//                    s = "";
//                } else {
//                    s = (String) o;
//                }
//                p.len = 4;
//                list.add(p);
//
//                Position temp = new Position();
//                temp.start = p.start + p.len;
//                temp.len = s.getBytes("UTF-8").length;
//                temp.buff = s.getBytes("UTF-8");
//                list.add(temp);
//
//                p.buff = int2byte(temp.len);
//            }
//
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private List<Field> getFieldList(Class<?> clazz) {
//        List<Field> list = new ArrayList<Field>();
//        try {
//            do {
//                list.addAll(Arrays.asList(clazz.getDeclaredFields()));
//                clazz = clazz.getSuperclass();
//            } while (clazz != null);
//            Iterator<Field> iterator = list.iterator();
//            while (iterator.hasNext()) {
//                Field item = iterator.next();
//                if (!item.isAnnotationPresent(Order.class)) {
//                    iterator.remove();
//                }
//            }
//            return list;
//        } catch (Exception e) {
//        }
//        return null;
//    }
//
//    /******************************************************************/
//    /** byte数组转基本类�? */
//    /******************************************************************/
//    private char byte2char(byte[] buff, int position) {
//        char ch = 0;
//        for (int i = 1; i >= 0; i--) {
//            ch = (char) (ch * 256 + (buff[position + i] & 0xff));
//        }
//        return ch;
//    }
//
//    private byte byteArray2byte(byte[] buff, int position) {
//        return buff[position];
//    }
//
//    private short byte2short(byte[] buff, int position) {
//        short sum = 0;
//        for (int i = 1; i >= 0; i--) {
//            sum = (short) (sum * 256 + (buff[position + i] & 0xff));
//        }
//        return sum;
//    }
//
//    private int byte2int(byte[] buff, int position) {
//        int sum = 0;
//        for (int i = 3; i >= 0; i--) {
//            sum = sum * 256 + (buff[position + i] & 0xff);
//        }
//        return sum;
//    }
//
//    private long byte2long(byte[] buff, int position) {
//        long sum = 0;
//        for (int i = 7; i >= 0; i--) {
//            sum = sum * 256 + (buff[position + i] & 0xff);
//        }
//        return sum;
//    }
//
//    private float byte2float(byte[] buff, int position) {
//        int i = byte2int(buff, position);
//        return Float.intBitsToFloat(i);
//    }
//
//    private double byte2double(byte[] buff, int position) {
//        long i = byte2long(buff, position);
//        return Double.longBitsToDouble(i);
//    }
//
//    private String byte2String(byte[] buff, int x, int i) {
//        try {
//            String str = new String(buff, x, i, "UTF-8");
//            return str;
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /******************************************************************/
//    /** 基本类型转byte数组 */
//    /******************************************************************/
//    private byte[] double2byte(Double d) {
//        long i = Double.doubleToLongBits(d);
//        return long2byte(i);
//    }
//
//    private byte[] float2byte(Float f) {
//        int i = Float.floatToIntBits(f);
//        return int2byte(i);
//    }
//
//    private byte[] long2byte(Long o) {
//        byte[] buff = new byte[8];
//        for (int i = 0; i < 8; i++) {
//            buff[i] = (byte) (o >> 8 * i & 0xff);
//        }
//        return buff;
//    }
//
//    private byte[] int2byte(Integer o) {
//        byte[] buff = new byte[4];
//        for (int i = 0; i < 4; i++) {
//            buff[i] = (byte) (o >> 8 * i & 0xff);
//        }
//        return buff;
//    }
//
//    private byte[] char2byte(char o) {
//        byte[] buff = new byte[2];
//        buff[0] = (byte) (o & 0xff);
//        buff[1] = (byte) (o >> 8 & 0xff);
//        return buff;
//    }
//
//    private byte[] short2byte(Short o) {
//        byte[] buff = new byte[2];
//        buff[0] = (byte) (o & 0xff);
//        buff[1] = (byte) (o >> 8 & 0xff);
//        return buff;
//    }
//
//    private byte[] byte2byteArray(byte o) {
//        return new byte[] { (byte) (o & 0xff) };
//    }
//
//}
