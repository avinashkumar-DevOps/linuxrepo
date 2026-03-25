#!/bin/bash

# ==========================================
# 🎨 COLOR DEFINITIONS
# ==========================================
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
CYAN='\033[0;36m'
MAGENTA='\033[0;35m'
WHITE='\033[1;37m'
NC='\033[0m' # No Color

# ==========================================
# 🖥️ HEADER
# ==========================================
echo -e "${MAGENTA}==========================================${NC}"
echo -e "${WHITE}      SYSTEM INFORMATION DASHBOARD${NC}"
echo -e "${MAGENTA}==========================================${NC}"
echo ""

# ------------------------------------------
# 📅 Date & Time
# ------------------------------------------
echo -e "${CYAN}📅 Current Date & Time:${NC}"
date
echo ""

# ------------------------------------------
# ⏱️ Uptime
# ------------------------------------------
echo -e "${CYAN}⏱️ System Uptime:${NC}"
uptime
echo ""

# ------------------------------------------
# 💾 Memory Usage
# ------------------------------------------
echo -e "${GREEN}💾 Memory Usage:${NC}"
free -h
echo ""

# ------------------------------------------
# 🧠 System Info
# ------------------------------------------
echo -e "${BLUE}🧠 System Information:${NC}"
uname -a
echo ""

# ------------------------------------------
# 📂 Disk Usage
# ------------------------------------------
echo -e "${YELLOW}📂 Disk Usage:${NC}"
df -h
echo ""

# ------------------------------------------
# 👥 Users
# ------------------------------------------
echo -e "${CYAN}👥 Logged-in Users:${NC}"
who
echo ""

# ------------------------------------------
# 📦 Directory Usage
# ------------------------------------------
echo -e "${MAGENTA}📦 Current Directory Size:${NC}"
du -sh .
echo ""

echo -e "${MAGENTA}📦 Directory Breakdown:${NC}"
du -h --max-depth=1 2>/dev/null
echo ""

# ------------------------------------------
# 🔥 Top Processes
# ------------------------------------------
echo -e "${RED}🔥 Top 5 Memory Processes:${NC}"
ps -eo pid,cmd,%mem,%cpu --sort=-%mem | head -n 6
echo ""

echo -e "${RED}⚡ Top 5 CPU Processes:${NC}"
ps -eo pid,cmd,%mem,%cpu --sort=-%cpu | head -n 6
echo ""

# ------------------------------------------
# 🌐 Network
# ------------------------------------------
echo -e "${GREEN}🌐 IP Address:${NC}"
hostname -I
echo ""

# ==========================================
# ✅ FOOTER
# ==========================================
echo -e "${MAGENTA}==========================================${NC}"
echo -e "${WHITE}        END OF REPORT${NC}"
echo -e "${MAGENTA}==========================================${NC}"




-------------------------------------------------------------------------------------------------

vi system_info_color.sh
chmod +x system_info_color.sh
./system_info_color.sh
