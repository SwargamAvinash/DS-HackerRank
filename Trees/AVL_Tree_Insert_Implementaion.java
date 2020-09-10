	/* Class node is defined as :
    class Node 
    	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child

	*/
    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T1 = x.right;
        
        //Right Rotate
        x.right = y;
        y.left = T1;
        
        y.ht = Math.max(height(y.left), height(y.right)) + 1;
        x.ht = Math.max(height(x.left), height(x.right)) + 1;
        
        return x;
    }

    static Node leftRotate(Node z) {
        Node y = z.right;
        Node T2 = y.left;
    
        //Left rotate
        y.left = z;
        z.right = T2;
        
        z.ht = Math.max(height(z.left), height(z.right)) + 1;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;

        // System.out.println(y.val + " ---> " + y.ht);
        // System.out.println(z.val + " ---> " + z.ht);
        
        return y;
    }

    static int height(Node root) {
        if(root == null) {
            return -1;
        }
        return root.ht;
    }
    
    static int balance(Node root) {
        if (root == null) {
            return 0;
        }
        return (height(root.left) - height(root.right));
    }

	static Node insert(Node root,int val)
    {
        if(root == null) {
            Node newNode = new Node();
            newNode.val = val;
            newNode.left = newNode.right = null;
            newNode.ht = 0;
            
            // System.out.println(newNode.val + "--> Inserted");
            return newNode;
        }
        
        if (val > root.val) {
            root.right =  insert(root.right, val);
        }else if (val < root.val) {
            root.left = insert(root.left, val);
        }else {
            return root;
        }
        
        root.ht = Math.max(height(root.left), height(root.right)) + 1;
        
        int bal = balance(root);
        // System.out.println(root.val + " ---> " + bal + " --> " + root.ht);
        
        // Left Left Case
        if (bal > 1 && val < root.left.val) {
            // System.out.println("LLC");
            return rightRotate(root);
        }
        
        //Right Right Case
        if (bal < -1 && val > root.right.val) {
            // System.out.println("RRC");
            return leftRotate(root);
        }
        
        //Left Right Case
        if (bal > 1 && val > root.left.val) {
            // System.out.println("LRC");
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        
        //Right Left Case
        if (bal < -1 && val < root.right.val) { 
            // System.out.println("RLC");
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
    	return root;
    }