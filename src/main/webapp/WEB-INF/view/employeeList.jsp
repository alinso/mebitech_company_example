<jsp:include page="partials/reactHeader.jsp" />

<script type="text/babel">
    document.title = "Employee List";

    const buttonInstance = (
            <ReactBootstrap.ButtonToolbar>
                <a href={'/edit-employee/0'}>
                <ReactBootstrap.Button bsStyle="success">Add New</ReactBootstrap.Button>
                </a>
            </ReactBootstrap.ButtonToolbar>
    );

    ReactDOM.render(buttonInstance, titleDiv);

    getJSONP("/employeeListRest/",function(obj) {




        class TableRow extends React.Component {
            render() {
                const {
                    data
                } = this.props;

                const row = data.map((data) =>

                        <tr>
                            <td key={data.id}>{data.id}</td>
                            <td key={data.name}>{data.name}</td>
                            <td key={data.salary}>{data.salary}</td>
                            <td><a href={'/edit-employee/'+data.id}><button className="btn btn-primary"> EDIT</button></a>&nbsp;
                                <button className="btn btn-danger" onClick={() => deleteRecord('/delete-employee'+data.id)}> DELETE</button></td>
                        </tr>
                );
                return (
                        <tbody>{row}</tbody>
                );
            }
        }

        class Table extends React.Component {
            constructor(props) {
                super(props);
            }
            render() {
                return (
                        <table className="table table-striped">
                            <thead><tr><td>ID</td><td>Name</td><td>Salary</td><td>Action</td></tr></thead>
                            <TableRow data={this.props.data} />
                        </table>
                );
            }
        }

        ReactDOM.render(<Table data={obj} />, container);

    });

</script>
