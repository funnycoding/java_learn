package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 5:58 下午
 */

class DynamicFieldsException extends Exception {
}

public class DynamicFields {
    // 一个存储信息的二维数组
    private Object[][] fields;

    // 初始化 二维数组，第二维只包含2个元素
    public DynamicFields(int initiaSize) {
        fields = new Object[initiaSize][2];
        for (int i = 0; i < initiaSize; i++) {
            fields[i] = new Object[]{null, null};
        }
    }

    // 打印数组中的元素
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object[] obj : fields) {
            result.append(obj[0]);
            result.append(": ");
            result.append(obj[1]);
            result.append("\n");

        }
        return result.toString();
    }

    // 判断数组中是否包含传入的值 返回-1表示不包含
    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (id.equals(fields[i][0])) {
                return i;
            }
        }
        return -1;
    }

    // 调用判断是否包含对应元素的方法，如果返回-1抛出异常
    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNum = hasField(id);
        if (fieldNum == -1) {
            throw new NoSuchFieldException();
        }
        return fieldNum;
    }

    // 遍历 fields 如果二维数组的第一个元素为空，则将传入id赋值给第一个元素并返回
    private int makeField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }
        // 如果不为空，则将id放入第二个元素中
        // No Empty Fields . Add One
        // 创建一个新的临时数组，其维度比 fields 的第一个元素长度大1
        Object[][] tmp = new Object[fields.length + 1][2];
        // 遍历 fields 给 tmp 临时数组赋值
        for (int i = 0; i < fields.length; i++) {
            tmp[i] = fields[i];
        }

        // 将tmp 比 fields 长的那个两个元素的数组初始化
        for (int i = fields.length; i < tmp.length; i++) {
            tmp[i] = new Object[]{null, null};
        }
        // 将临时数组赋值给fields 赋值完成
        fields = tmp;
        // 具有扩展字段的递归调用 将id赋值给刚才拓展的那个二维数组的第一个元素
        return makeField(id);
    }


    // 获得二维数组的第一个元素
    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    // 异常链的
    public Object setField(String id, Object value) throws DynamicFieldsException {
        if (value == null) {
            System.out.println("入参 value 为 null，抛出异常。");
            // Most exceptions don't have a "cause"
            // constructor. In these cases you must use
            // initCause(), available in all
            // Throwable subclasses.
            DynamicFieldsException dfe = new DynamicFieldsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldNumber = hasField(id);
        if (fieldNumber == -1) {
            fieldNumber = makeField(id);
        }
        Object result = null;

        try {
            result = getField(id); // Get Old Value
        } catch (NoSuchFieldException e) {
            // Use constructor that takes "cause": 异常链的调用，将 NosuchFieldException 转为 Runtime Exception
            throw new RuntimeException(e);
        }
        // 数组赋值
        fields[fieldNumber][1] = value;
        return result;
    }

    public static void main(String[] args) {
        // 生成一个 Object[3][2] 的二维数组
        DynamicFields df = new DynamicFields(3);

        System.out.println(df);

        try {
            df.setField("d", "A value for d");
            df.setField("number", 47);
            df.setField("number2", 48);
            System.out.println(df);
            df.setField("d", "A new Value for d");
            df.setField("number3", 11);
            System.out.println("df: " + df);
            System.out.println("df.getFiled(\"d\") : " + df.getField("d"));

            Object d = df.setField("d", null);

        } catch (DynamicFieldsException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
