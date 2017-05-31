#!/usr/local/bin/perl -- -*-perl-*-

# mkindex.pl -- recursively makes an index file of http links to all
#  the *.html and *.java files in subdirectories of the cwd
# ------------------------------------------------------------

use Cwd;
$rootdir = $path = cwd();  		# get current working directory
#$rootdir =~ s/^(\/.*\/)(.*$)/$2/i;      # Use directory name as the root
$rootdir = ".";                          # Use '.' for relative path 

$htmlroot = "http://troy.trincoll.edu/~jjjava/exsolutions"; # Set root HTTP address
print "cwd= $path\n";
print "root = $rootdir\n";

$index = "index.html";                  # Name of output file (HTML format)

open (INDEX, ">$index");	
print INDEX "<html>\n<head>\n<title>HTML Index for $rootdir Directory</title>\n</head>\n<body>\n";
print INDEX "<center><h2>HTML Index for $rootdir Directory</h2>\n";
print INDEX "<a name=\"top\">\n";
print INDEX "<table><tr><td>[|\n";


@dirlist = ();                                    # create an empty directory list
@filelist = <*>;                                  # get a list of file names in the directory
for ($i=0; $i < scalar(@filelist); $i++) {
    if (-d @filelist[$i]) {
	@dirlist[++$#dirlist] = @filelist[$i] ;   # construct a list of the main subdirectories
    }
}
foreach $d (@dirlist) {                           # use directories to make a navigation table
    print INDEX "<a href=\"\#$d\">$d</a> |\n";		
}
print INDEX "]</td></tr></table></center>\n";
build_index(@dirlist);            

print INDEX "</body>\n</html>\n";
close (INDEX);

print "\nCreated $index\n";

sub build_index {
    my($flag) = 0;
    my($dir) = cwd();                   # Remember path
    foreach $file (@_) {
#	print "$file\n";
        if (-d "$file") {                    # If this is a directory 
            local($rootdir) = $rootdir;
            $rootdir .= "/$file";
#            print "$rootdir\n";
	    chdir "$file";                      # Change the current working directory
            build_index(<*>);                   # Recursively process the subdirectories
	    chdir "$dir";                       # Change to the parent directory
        }
	if ($file =~ /\.html$|\.java$/) {
	    if ( $flag++ == 0) {
		print INDEX "\n<h4>Directory: $rootdir  ";
		if ($rootdir =~ /@dirlist[0]/) {                       # If this is the first entry for a subdirectory
		    print INDEX "<a name=\"@dirlist[0]\">\n";          # create a local navigation anchor         
		    print INDEX "<a href=\"\#top\"> [Top of Page]</a>\n"; # and a backref to top of page
		    shift @dirlist;
		}
		print INDEX "</h4>\n";
	    }	
	    print INDEX "\n<LI><a href = \"$rootdir/$file\">$file</a>\n";
#	    print INDEX "\n<LI><a href = \"$htmlroot/$rootdir/$file\">$file</a>\n";
	}
    }
}


