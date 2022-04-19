const makeStyles = (value, index, isUserSelected, isSidebarOpen) => {
    const adminPanelDisplay = value == index ? "block" : "none";
    const searchContainerDisplay = isUserSelected ? "none" : "block";
    const selectionContainerDisplay = isUserSelected ? "flex" : "none";
    const sidebarDisplay = isSidebarOpen ? "block" : "none";
    const leftContainerWidth = isSidebarOpen ? "65%" : "100%";
    const sidebarRightValue = isSidebarOpen ? "0" : "-300px";
    const sidebarWidth = isSidebarOpen ? "35%" : "0px";

    return {
        container: {
            display: adminPanelDisplay,
            width: "100%",
            height: "557px",
            ['#searchHR']: {
                color: 'lightgrey',
                margin: "10px 20px 10px 20px"
            }
        },
        searchContainer: {
            display: searchContainerDisplay,
        },
        adminHeader: {
            display: "flex",
            columnGap: "20px",
            width: "600px",
            padding: "40px 0 20px 20px",
        },
        addUserButton: {
            backgroundColor: "saveButtonColor",
        },
        searchField: {
            flexGrow: "1",
        },
        resultsContainer: {
            maxHeight: "420px",
            padding: "0 20px 0 20px",
            overflow: "auto",
        },
        tableRow: {
            cursor: 'cell',
            [':hover']: {
                backgroundColor: 'lightgrey'
            }
        },
        selectionContainer: {
            display: selectionContainerDisplay,
            height: "557px",
            overflow: "hidden",

        },
        leftInfoContainer: {
            width: leftContainerWidth,
            transition: "width 0.3s",
            padding: '10px 0 0 10px',
            ['#selectionHR']: {
                color: 'lightgrey',
                margin: "25px 20px 10px 0"
            }
        },
        rightSidebarContainer: {
            display: sidebarDisplay,
            position: "relative",
            right: sidebarRightValue,
            width: sidebarWidth,
            height: "100%",
            overflow: "auto",
            transition: "right 0.4s",
            borderLeft: "2px solid lightgrey",
        },
        mediaContainer: {
            display: "flex",
            maxHeight: "390px",
            flexWrap: "wrap",
            justifyContent: "center",
            columnGap: "20px",
            rowGap: "20px",
            padding: "30px",
            overflowY: "auto",
        },
        actionBar: {
            width: "100%",
            backgroundColor: "primary.main",
            button: {
                color: "white"
            }    
        },
        editButton: {
            marginLeft: "auto"
        },
        userInfoContainer: {
            display: "grid",
            padding: "20px",
            gridTemplateColumns: "auto auto",
        }
    }
}

export default makeStyles;