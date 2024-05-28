public class Task_01 {
    public static void main(String[] args) {
        public class Main {

            private int[][] matrix;

            private int size;

            public Main(int size) {
                this.size = size;
                this.matrix = new int[size][size];
            }

            // Создание единичной (диагональной) матрицы
            public static Main createIdentityMatrix(int size) {
                Main matrix = new Main(size);
                for (int i = 0; i < size; i++) {
                    matrix.matrix[i][i] = 1;
                }
                return matrix;
            }

            // Создание нулевой матрицы
            public static Main createZeroMatrix(int size) {
                return new Main(size);
            }

            // Сложение матриц
            public Main add(Main other) {
                if (this.size != other.size) {
                    throw new IllegalArgumentException("Матрицы должны быть одного размера");
                }

                Main result = new Main(size);
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        result.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j];
                    }
                }
                return result;
            }

            // Умножение матриц
            public Main multiply(Main other) {
                if (this.size != other.size) {
                    throw new IllegalArgumentException("Матрицы должны быть одного размера");
                }

                Main result = new Main(size);
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        int sum = 0;
                        for (int k = 0; k < size; k++) {
                            sum += this.matrix[i][k] * other.matrix[k][j];
                        }
                        result.matrix[i][j] = sum;
                    }
                }
                return result;
            }

            // Умножение матрицы на скаляр
            public Main multiplyByScalar(int scalar) {
                Main result = new Main(size);
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        result.matrix[i][j] = this.matrix[i][j] * scalar;
                    }
                }
                return result;
            }

            // Определение детерминанта матрицы
            public int determinant() {
                if (size == 1) {
                    return matrix[0][0];
                }

                int det = 0;
                int sign = 1;
                for (int i = 0; i < size; i++) {
                    int minorDet = createMinorMatrix(0, i).determinant();
                    det += sign * matrix[0][i] * minorDet;
                    sign *= -1;
                }
                return det;
            }

            // Создание минорной матрицы
            private Main createMinorMatrix(int row, int col) {
                Main minor = new Main(size - 1);
                int minorRow = 0;
                int minorCol;
                for (int i = 0; i < size; i++) {
                    if (i == row) {
                        continue;
                    }
                    minorCol = 0;
                    for (int j = 0; j < size; j++) {
                        if (j == col) {
                            continue;
                        }
                        minor.matrix[minorRow][minorCol] = matrix[i][j];
                        minorCol++;
                    }
                    minorRow++;
                }
                return minor;
            }

            // Вывод матрицы на консоль
            public void printMatrix() {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }

            public static void main(String[] args) {
                Main matrix1 = Main.createIdentityMatrix(3);
                Main matrix2 = Main.createZeroMatrix(3);

                matrix1.printMatrix();
                System.out.println();

                matrix2.printMatrix();
                System.out.println();

                Main sumMatrix = matrix1.add(matrix2);
                sumMatrix.printMatrix();
                System.out.println();

                Main productMatrix = matrix1.multiply(matrix2);
                productMatrix.printMatrix();
                System.out.println();

                Main scalarMatrix = matrix1.multiplyByScalar(2);
                scalarMatrix.printMatrix();
                System.out.println();

                int determinant = matrix1.determinant();
                System.out.println("Determinant: " + determinant);
            }
        }
    }
}
