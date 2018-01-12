import java.io.File;
import java.util.Stack;

public class GetFoldFileNames {

    /**
     *
     * @author zdz8207
     */

    public static Stack<String> getFileName() {
        String path = "./"; // 路径
        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
            return null;
        }

        File fa[] = f.listFiles();
        Stack<String> res = new Stack<>();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (!fs.isDirectory() && fs.getName().endsWith(".c")) {
                res.push(fs.getName());
            }
        }
        return res;
    }
}