import { Box } from '@mui/material'
import React, { useState } from 'react'
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import PersonOutlineOutlinedIcon from '@mui/icons-material/PersonOutlineOutlined';
import CollectionsOutlinedIcon from '@mui/icons-material/CollectionsOutlined';
import AdminPanelSettingsIcon from '@mui/icons-material/AdminPanelSettings';
import { Paper } from '@mui/material';

import Header from '../../components/Header/Header'
import AccountPanel from './AccountPanel/AccountPanel';
import GalleryPanel from './GalleryPanel/GalleryPanel';
import AdminPanel from './AdminPanel/AdminPanel';
import styles from  './styles';

function UserViewAccount() {
    const [tabValue, setTabValue] = useState(0);

    const handleChange = (event, newValue) => {
        setTabValue(newValue);
    }

    return (
        <Box sx={{ backgroundColor: "backgroundColor1", height: "100vh" }}>
            <Header />
            <Paper sx={styles.paper}>
            <Box sx={styles.tabContainer}>
                <Box sx={{ borderBottom: 1, bordercolor: 'grey' }} >
                    <Tabs value={tabValue} onChange={handleChange} aria-label="interface tabs" >
                        <Tab label="Account" icon={<PersonOutlineOutlinedIcon />} iconPosition="start" />
                        <Tab label="Gallery" icon={<CollectionsOutlinedIcon />} iconPosition="start" />
                        <Tab label="Admin" icon={<AdminPanelSettingsIcon />} iconPosition="start" />
                    </Tabs>
                </Box>
                <AccountPanel value={tabValue} index={0} />
                <GalleryPanel value={tabValue} index={1} />
                <AdminPanel value={tabValue} index={2} />
            </Box>
            </Paper>
        </Box>
    )
}

export default UserViewAccount