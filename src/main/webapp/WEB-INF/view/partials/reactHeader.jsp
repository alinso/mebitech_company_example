
<script src="https://unpkg.com/react@16.2.0/umd/react.development.js"></script>
<script src="https://unpkg.com/react-dom@16.2.0/umd/react-dom.development.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react-bootstrap/0.31.5/react-bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/require.js"></script>
<script src="${pageContext.request.contextPath}/app.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<body></body>

<script>


var node = document.createElement("div");
var container  =document.createElement("div");
container.className += " col-md-8";
document.getElementsByTagName('body')[0].appendChild(node);
document.getElementsByTagName('body')[0].appendChild(container);

var navInstance = React.createElement(
ReactBootstrap.Nav,
{ bsStyle: "pills" },


React.createElement(
ReactBootstrap.NavItem,
{ eventKey: 1, href: "/employeeList" },
"Employees"
),

React.createElement(
ReactBootstrap.NavItem,
{ eventKey: 2, href: "/departmentList" },
"Departments"
),

React.createElement(
ReactBootstrap.NavItem,
{ eventKey: 3, href: "/meetingList" },
"Meetings"
)
);

ReactDOM.render(navInstance, node);



function _objectWithoutProperties(obj, keys) { var target = {}; for (var i in obj) { if (keys.indexOf(i) >= 0) continue; if (!Object.prototype.hasOwnProperty.call(obj, i)) continue; target[i] = obj[i]; } return target; }

function FieldGroup(_ref) {
    var id = _ref.id,
        label = _ref.label,
        help = _ref.help,
        props = _objectWithoutProperties(_ref, ["id", "label", "help"]);

    return React.createElement(
        ReactBootstrap.FormGroup,
        { controlId: id },
        React.createElement(
            ReactBootstrap.ControlLabel,
            null,
            label
        ),
        React.createElement(ReactBootstrap.FormControl, props),
        help && React.createElement(
        ReactBootstrap.HelpBlock,
        null,
        help
        )
    );
}
</script>