#/bin/bash

echo "
███████╗███████╗████████╗    ██████╗  ██████╗    ██╗   ██╗██████╗ 
██╔════╝██╔════╝╚══██╔══╝    ██╔══██╗██╔════╝    ██║   ██║██╔══██╗
███████╗█████╗     ██║       ██████╔╝██║         ██║   ██║██████╔╝
╚════██║██╔══╝     ██║       ██╔═══╝ ██║         ██║   ██║██╔═══╝ 
███████║███████╗   ██║       ██║     ╚██████╗    ╚██████╔╝██║     
╚══════╝╚══════╝   ╚═╝       ╚═╝      ╚═════╝     ╚═════╝ ╚═╝     
"   
echo "                                                             
█████╗█████╗█████╗█████╗█████╗█████╗█████╗█████╗█████╗█████╗█████╗█████╗
╚════╝╚════╝╚════╝╚════╝╚════╝╚════╝╚════╝╚════╝╚════╝╚════╝╚════╝╚════╝

"

echo "Start ..."
apt-get update
echo "Update Done!"

apt-get upgrade -y
echo "Upgrade Done!"

echo "Installing git ..."
apt-get install git -y
echo "Insall git Done!"
git config --global user.name "Nicolò Vescera"
git config --global user.email "slayercandy@icloud.com"
echo "Git configuration Done!"

echo "Installing Gedit ..."
apt-get install gedit -y
echo "Install Gedit Done!"

echo "Installing NetBeans ..."
wget http://download.netbeans.org/netbeans/8.0.2/final/bundles/netbeans-8.0.2-cpp-linux.sh
chmod +x netbeans-8.0.2-cpp-linux.sh
./netbeans-8.0.2-cpp-linux.sh
rm netbeans-8.0.2-cpp-linux.sh
echo "Install NetBeans Done!"
echo "Vuoi anche il plugin Python?"
echo "[1]Si	[0]No"
read plugin
case $plugin in
	1) wget http://plugins.netbeans.org/download/plugin/3380
	   unzip 3380
	   echo "Pthon Plugin Done!";;
esac

cd
cd Documenti/
mkdir gitdocs

echo "Done!"                                                          
