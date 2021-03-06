{
  'id': 'rootNode', // It's a optional property which will be used as id attribute of node
  // and data-parent attribute, which contains the id of the parent node
  'collapsed': true, // By default, the children nodes of current node is hidden.
  'className': 'top-level', // It's a optional property
  // which will be used as className attribute of node.
  'nodeTitle': 'name', // This property is used to retrieve “title” value in datasource
  'nodeContent': 'title',// This property is used to retrieve "content" value in datasource
  'relationship': relationshipValue, // Note: when you activate ondemand loading nodes feature,
  // you should use json datsource (local or remote) and set this property.
  // This property implies that whether this node has parent, siblings, children.
  // relationshipValue is a string composed of three "0/1" identifier.
  // First character stands for wether current node has parent node;
  // Scond character stands for wether current node has siblings nodes;
  // Third character stands for wether current node has children node.
  'children': [ // The property stands for nested nodes.
    { 'name': 'Bo Miao', 'title': 'department manager', 'relationship': '110' },
    { 'name': 'Su Miao', 'title': 'department manager', 'relationship': '111',
      'children': [
        { 'name': 'Tie Hua', 'title': 'senior engineer', 'relationship': '110' },
        { 'name': 'Hei Hei', 'title': 'senior engineer', 'relationship': '110' }
      ]
    },
    { 'name': 'Yu Jie', 'title': 'department manager', 'relationship': '110' }
  ],
  'otherPro': anyValue // feel free to append any useful properties
};