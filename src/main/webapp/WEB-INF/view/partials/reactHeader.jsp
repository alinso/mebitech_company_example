<meta charset="utf-8" />
<script src="https://unpkg.com/babel-standalone@6.26.0/babel.min.js" charset="utf-8"></script>
<script src="https://unpkg.com/react@16.2.0/umd/react.development.js"></script>
<script src="https://unpkg.com/react-dom@16.2.0/umd/react-dom.development.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react-bootstrap/0.31.5/react-bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/require.js"></script>
<script src="${pageContext.request.contextPath}/app.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">


<body></body>

<script type="text/babel">


var node = document.createElement("div");
var container  =document.createElement("div");
var titleDiv  =document.createElement("div");
var buttonDiv  =document.createElement("div");


var setPageTitle  =function(text){
    document.title = text;
    titleDiv.innerHTML = '<h4>'+text+'<h4><br/><br/>';
}


container.className += " col-md-8";
document.getElementsByTagName('body')[0].appendChild(node);
document.getElementsByTagName('body')[0].appendChild(titleDiv);
document.getElementsByTagName('body')[0].appendChild(buttonDiv);
document.getElementsByTagName('body')[0].appendChild(container);

var navInstance = React.createElement(
ReactBootstrap.Nav,
{ bsStyle: "pills" },


React.createElement(
ReactBootstrap.NavItem,
{ eventKey: 1, href: "/employee-list" },
"Employees"
),

React.createElement(
ReactBootstrap.NavItem,
{ eventKey: 2, href: "/department-list" },
"Departments"
),

React.createElement(
ReactBootstrap.NavItem,
{ eventKey: 3, href: "/meeting-list" },
"Meetings"
)
);

ReactDOM.render(navInstance, node);



function FieldGroup({ id, label, help, ...props }) {
    return (
            <ReactBootstrap.FormGroup controlId={id}>
                <ReactBootstrap.ControlLabel>{label}</ReactBootstrap.ControlLabel>
                <ReactBootstrap.FormControl {...props} />
                {help && <ReactBootstrap.HelpBlock>{help}</ReactBootstrap.HelpBlock>}
            </ReactBootstrap.FormGroup>
    );
}
</script>