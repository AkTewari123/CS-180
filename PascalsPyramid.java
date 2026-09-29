/* 
  * Program: PascalsPyramid.java
  * @version 9/29/26
  * @author Akshat Tewari
  * Description: This program is calculate the layers, rows, and values of Pascal's Pyramid
  * for a user-given amount of layers. It then prints out the appropriate layer based on user 
  * input.
*/


void main() {
    int numLayers = Integer.parseInt(IO.readln("Enter the number of layers:\n"));
    int layerNumRead = Integer.parseInt(IO.readln("Enter the layer to display:\n"));
    var pyramid = new ArrayList<ArrayList<ArrayList<Integer>>>();
    for (int x = 0; x < numLayers; x++) {
        var thisLayer = new ArrayList<ArrayList<Integer>>();
        int prevLayerNum = x - 1 >= 0 ? x - 1 : 0;

        // how many rows are in the layer
        int nRows = x + 1;
        // IO.println(pyramid.toString());
        // IO.println("LAYER NUMBER: " + x);
        for (int y = 0; y < nRows; y++) {
            // IO.println("ROW NUMBER: " + y);

            // Current row of the layer to be added to "thisLayer"
            var row = new ArrayList<Integer>();

            // number of elements in the row that's to be created
            int numElements = nRows - y;
            
            // get the corresponding row of the previous layer
            ArrayList<Integer> correspondingRow ;
            
            // get the one above it for top vertex
            ArrayList<Integer> prevRow ;
            for (int z = 0; z < numElements; z++) {
                // IO.println("ELEMENT NUMBER: " + z);
                
                
                if (x == 0) {
                    // first layer/loop
                    row.add(1);
                    break;
                } else {
                    var prevLayer = pyramid.get(prevLayerNum);

                    // use triangles on the prevLayer to compute thisLayer
                    int topVertex ;
                    int leftVertex ;
                    int rightVertex ;
                    
                    // accessing the element above the current one
                    if (y == 0) {
                        // you are building the 0th row, so prevRow is undefined
                        prevRow = prevLayer.get(y); // avoid errors in the future
                        topVertex = 0;
                    } else if (y == nRows - 1 ) {
                        row.add(1);
                        break;
                    } else {
                        prevRow = prevLayer.get(y - 1);
                        topVertex = prevRow.get(z);
                    }

                    correspondingRow = prevLayer.get(y);

                    if (z == numElements - 1) {
                        rightVertex = 0;
                    } else {
                        rightVertex = correspondingRow.get(z);
                    }
                    
                    if (z == 0) {
                        leftVertex = 0;
                    } else {
                        leftVertex = correspondingRow.get(z - 1);
                    }
                    
                    
                    int num = leftVertex + rightVertex + topVertex;
                    // IO.println(String.format("num %d calculated at x: %d, y:%d, z:%d", num, x, y, z));
                    // IO.println(String.format("with numbers rightVertex: %d, leftVertex: %d, topVertex: %d", rightVertex, leftVertex, topVertex));
                    row.add(num);
                }
                
            }
            // IO.println("adding row: " + row.toString());
            // IO.println();
            thisLayer.add(row);
        }
        pyramid.add(thisLayer);
    }
    var layerToPrint = pyramid.get(layerNumRead);
    IO.println(String.format("Layer %d", layerNumRead));
    for (int x = 0; x < layerToPrint.size(); x++) {
        var rowToPrint = (layerToPrint.get(x));
        for (int y = 0; y < rowToPrint.size(); y++) {
            IO.print(rowToPrint.get(y));
            if (y < rowToPrint.size() - 1) {
                IO.print(" ");
            }
        }
        IO.println();
    }
}