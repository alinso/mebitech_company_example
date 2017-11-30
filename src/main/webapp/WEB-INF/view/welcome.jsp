<jsp:include page="partials/reactHeader.jsp" />

<script type="text/babel">

    document.title = "Meeting List";
    const panelInstance = (
                <ReactBootstrap.Panel>
                    Welcome to Meeting sample application.<br/>
                    You can navigate any page from menu and manage tasks.
                </ReactBootstrap.Panel>
        );

        ReactDOM.render(panelInstance, container);

</script>
