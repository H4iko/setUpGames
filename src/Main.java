import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder buffer = new StringBuilder();
        String path = scanner.nextLine();
        File src = new File(path + "/src");
        File res = new File(path + "/res");
        File savegames = new File(path + "/savegames");
        File temp = new File(path + "/temp");

        if (src.mkdir()) {
            buffer.append("src directory was created.\n");
        } else {
            buffer.append("src directory wasn't created.\n");
        }

        if (src.exists()) {
            File main = new File(src.getAbsolutePath() + "/main");
            File test = new File(src.getAbsolutePath() + "/test");

            if (main.mkdir()) {
                buffer.append("main directory was created.\n");
            } else {
                buffer.append("main directory wasn't created.\n");
            }
            if (main.exists()) {
                File Main = new File(main.getAbsolutePath() + "/Main.java");
                File Utils = new File(main.getAbsolutePath() + "/Utils.java");

                try {
                    if (Main.createNewFile()) {
                        buffer.append("Main.java was created.\n");
                    } else {
                        buffer.append("Main.java wasn't created.\n");
                    }
                } catch (IOException e) {
                    buffer.append(e.getMessage()).append('\n');
                }

                try {
                    if (Utils.createNewFile()) {
                        buffer.append("Utils.java was created.\n");
                    } else {
                        buffer.append("Utils.java wasn't created.\n");
                    }
                } catch (IOException e) {
                    buffer.append(e.getMessage()).append('\n');
                }
            }

            if (test.mkdir()) {
                buffer.append("test directory was created.\n");
            } else {
                buffer.append("test directory wasn't created.\n");
            }
        }

        if (res.mkdir()) {
            buffer.append("res directory was created.\n");
        } else {
            buffer.append("res directory wasn't created.\n");
        }

        if (res.exists()) {
            File drawable = new File(res.getAbsolutePath() + "/drawable");
            File vectors = new File(res.getAbsolutePath() + "/vectors");
            File icons = new File(res.getAbsolutePath() + "/icons");

            if (drawable.mkdir()) {
                buffer.append("drawable directory was created.\n");
            } else {
                buffer.append("drawable directory wasn't created.\n");
            }

            if (vectors.mkdir()) {
                buffer.append("vectors directory was created.\n");
            } else {
                buffer.append("vectors directory wasn't created.\n");
            }

            if (icons.mkdir()) {
                buffer.append("icons directory was created.\n");
            } else {
                buffer.append("icons directory wasn't created.\n");
            }
        }

        if (savegames.mkdir()) {
            buffer.append("savegames directory was created.\n");
        } else {
            buffer.append("savegames directory wasn't created.\n");
        }

        if (temp.mkdir()) {
            buffer.append("temp directory was created.\n");
        } else {
            buffer.append("temp directory wasn't created.\n");
        }

        if (temp.exists()) {
            File Temp = new File(temp.getAbsolutePath() + "/temp.txt");

            try {
                if (Temp.createNewFile()) {
                    buffer.append("temp.txt was created.\n");
                } else {
                    buffer.append("temp.txt wasn't created.\n");
                }

                if (Temp.exists()) {
                    try(FileWriter writer = new FileWriter(Temp)) {
                        writer.append(buffer);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }

            } catch (IOException e) {
                buffer.append(e).append('\n');
            }
        }
    }
}
